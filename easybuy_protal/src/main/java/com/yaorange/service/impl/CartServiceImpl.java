package com.yaorange.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaorange.consts.bis.BooleanConsts;
import com.yaorange.mapper.TProductMapper;
import com.yaorange.mapper.TSkuMapper;
import com.yaorange.mapper.TVipCartMapper;
import com.yaorange.pojo.TProduct;
import com.yaorange.pojo.TSku;
import com.yaorange.pojo.TVipCart;
import com.yaorange.pojo.TVipCartExample;
import com.yaorange.pojo.TVipCartExample.Criteria;
import com.yaorange.service.CartService;
import com.yaorange.util.Ret;
import com.yaorange.util.StrUtils;
import com.yaorange.utils.SsoContext;

/**
 * 购物车业务类
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private TVipCartMapper vipCartMapper;
    @Autowired
    private TSkuMapper skuMapper;
    @Autowired
    private TProductMapper productMapper;


    /**
     * 购物车显示
     */
    @Override
    public Map<String, Object> cartsInfo() {
        List<TVipCart> vipCarts = queryVipCarts();
        //计算商品价格
        Map<String, Object> cartInfo = countCart(vipCarts);
        cartInfo.put("data", vipCarts);
        return cartInfo;
    }

    /**
     * 计算购物车信息
     *
     * @param vipCarts
     * @return
     */
    public Map<String, Object> countCart(List<TVipCart> vipCarts) {
        Map<String, Object> cartsInfo = new HashMap<>();
        int totalNumber = 0;
        int totalPrice = 0;
        int selectedTotalNumber = 0;
        int selectedTotalPrice = 0;
        for (TVipCart cart : vipCarts) {
            totalNumber += cart.getAmount();
            int partPrice = cart.getSku().getPrice() * cart.getAmount();
            totalPrice += partPrice;
            if (cart.getSelected() == BooleanConsts.YES) {
                selectedTotalNumber += cart.getAmount();
                selectedTotalPrice += partPrice;
            }
        }
        cartsInfo.put("goodsNumber", totalNumber);
        cartsInfo.put("goodsTotalPrice", totalPrice);
        cartsInfo.put("selectedGoodsNumber", selectedTotalNumber);
        cartsInfo.put("selectedGoodsTotalPrice", selectedTotalPrice);
        return cartsInfo;
    }


    /**
     * 查询购物车信息
     */
    public List<TVipCart> queryVipCarts() {
        Long ssoId = SsoContext.getSsoId();
        TVipCartExample example = new TVipCartExample();
        Criteria criteria = example.createCriteria();
        criteria.andSsoIdEqualTo(ssoId);
        //查询当前用户的购物车
        List<TVipCart> vipCarts = vipCartMapper.selectByExample(example);
        for (TVipCart cart : vipCarts) {
            TSku sku = skuMapper.selectByPrimaryKey(cart.getSkuId());
            cart.setSku(sku);
        }
        return vipCarts;
    }

    /**
     * 添加商品进购物车
     *
     * @param number
     * @param skuId
     */
    @Override
    public void add2Cart(Integer number, Long skuId) {
        //获取用户信息
        Long ssoId = SsoContext.getSsoId();
        TVipCartExample example = new TVipCartExample();
        Criteria criteria = example.createCriteria();
        criteria.andSsoIdEqualTo(ssoId);
        criteria.andSkuIdEqualTo(skuId);
        List<TVipCart> vipCarts = vipCartMapper.selectByExample(example);
        //说明之前添加过相同的sku
        if (vipCarts.size() > 0) {
            TVipCart existVipCart = vipCarts.get(0);
            existVipCart.setAmount(existVipCart.getAmount() + number);
            existVipCart.setSelected(BooleanConsts.YES);
            vipCartMapper.updateByPrimaryKeySelective(existVipCart);
        } else {
            //如果没有添加过该sku
            TSku sku = skuMapper.selectByPrimaryKey(skuId);
            Long productId = sku.getProductId();
            TProduct product = productMapper.selectByPrimaryKey(productId);
            TVipCart vipCart = new TVipCart();
            vipCart.setSkuMainPic(sku.getSkuMainPic());
            vipCart.setSkuProperties(sku.getSkuProperties());
            vipCart.setProductId(productId);
            vipCart.setName(product.getName());
            vipCart.setAmount(number);
            vipCart.setCreateTime(System.currentTimeMillis());
            vipCart.setSelected(BooleanConsts.YES);
            vipCart.setSkuId(skuId);
            vipCart.setSsoId(ssoId);
            vipCart.setStoreId(1L);
            vipCart.setStoreName("易购网官方一号店");
            //保存购物车
            vipCartMapper.insert(vipCart);
        }

    }


    /**
     * 购物车选中
     *
     * @param cartIds 购物车选中的ids
     * @return
     */
    @Override
    public Ret cartSelect(String cartIds) {
        Long[] cartIdArray = StrUtils.splitToLong(cartIds);
        Long ssoId = SsoContext.getSsoId();
        //勾选了一部分
        if (cartIdArray != null && cartIdArray.length > 0) {
            //更新商品选中情况
            vipCartMapper.selected(ssoId, cartIdArray);
            vipCartMapper.deSelected(ssoId, cartIdArray);
        } else {
            //全部没有勾选 --->设置该sku的商品全部未选中
            TVipCartExample example = new TVipCartExample();
            Criteria criteria = example.createCriteria();
            criteria.andSsoIdEqualTo(ssoId);
            TVipCart vipCart = new TVipCart();
            vipCart.setSelected(BooleanConsts.NO);
            vipCartMapper.updateByExampleSelective(vipCart, example);
        }
        List<TVipCart> vipCarts = queryVipCarts();
        Map<String, Object> countCart = countCart(vipCarts);
        return Ret.me().setData(countCart);
    }

    /**
     * 商品清单 --确认订单后需要
     */
    @Override
    public Map<String, Object> selectedSku() {
        List<TVipCart> selectedList = new ArrayList<>();
        //查询当前用户的购物车
        List<TVipCart> cartList = queryVipCarts();
        for (TVipCart vipCart : cartList) {
            if (vipCart.getSelected() == BooleanConsts.YES) {
                String skuProperties = vipCart.getSkuProperties();
                //截取sku_properties属性
                vipCart.setSkuProperties(StrUtils.changePropertyStyle(skuProperties));
                selectedList.add(vipCart);
            }
        }
        //计算购物车信息
        Map<String, Object> infoMap = this.countCart(cartList);
        infoMap.put("data", selectedList);
        return infoMap;
    }
}
