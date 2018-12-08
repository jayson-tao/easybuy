package com.yaorange.controller;


import java.util.Map;

import com.yaorange.consts.bis.BooleanConsts;
import com.yaorange.mapper.TProductMapper;
import com.yaorange.mapper.TSkuMapper;
import com.yaorange.pojo.TProduct;
import com.yaorange.pojo.TSku;
import com.yaorange.pojo.TVipCart;
import com.yaorange.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yaorange.service.CartService;
import com.yaorange.util.Ret;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TSkuMapper skuMapper;
    @Autowired
    private TProductMapper productMapper;

    /**
     * 显示购物车
     */
    @RequestMapping("/index")
    public String index(Model model) {
        Map<String, Object> cartsInfo = cartService.cartsInfo();
        model.addAttribute("cartInfo", cartsInfo);
        return "cart";
    }


    /**
     * 添加购物车
     * @param number 商品数量
     * @param skuId 商品skuId
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Ret add(Integer number, Long skuId) {
        cartService.add2Cart(number, skuId);
        return Ret.me();
    }

    /**
     * 购物车商品的选中
     * @param cartIds 选中的ids
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public Ret cartSelect(String cartIds) {
        return cartService.cartSelect(cartIds);
    }

    @RequestMapping("/settleAccounts")
    @ResponseBody
    public Ret settleAccounts(String cartIds) {
        Map<String, Object> countCarts = cartService.cartsInfo();
        Object selectedGoodsNumber = countCarts.get("selectedGoodsNumber");
        if (selectedGoodsNumber == null || Integer.parseInt(selectedGoodsNumber.toString()) == 0) {
            return Ret.me().setSuccess(false).setInfo("请至少选择一个商品哟");
        }
        return Ret.me();
    }

    /**
     * 立即购买
     * @param number
     * @param skuId
     */
    @RequestMapping("/immediatelyBuy")
    @ResponseBody
    public Ret immediatelyBuy(Integer number, Long skuId) {
        //查询sku信息
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
        vipCart.setStoreId(1L);
        vipCart.setStoreName("易购网官方一号店");
        //重定向到确认订单页面
        return Ret.me().setData("/order/confirm");
    }
}
