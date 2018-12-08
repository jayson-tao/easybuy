package com.yaorange.controller;

import java.util.HashMap;
import java.util.Map;

import com.yaorange.pojo.TSso;
import com.yaorange.service.AreaService;
import com.yaorange.service.CartService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaorange.util.Ret;
import com.yaorange.utils.SsoContext;

@Controller
public class HomeController {
    @Autowired
    private AreaService areaService;
    @Autowired
    private CartService cartService;

    /**
     * 返回用户购物车和消息数量 未登录：{"code":0,"data":{"cart":{"goods_count":0},"message":{
     * "internal_count":"0"}}}
     */
    @RequestMapping("/site-user")
    @ResponseBody
    public Ret siteUser() {
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> cart = new HashMap<>();
        cart.put("goods_count", 0);
        Map<String, Object> message = new HashMap<>();
        message.put("internal_count", 0);
        data.put("cart", cart);
        data.put("message", message);
        return Ret.me().setData(data);
    }

    @RequestMapping("/region-list")
    @ResponseBody
    public Map<String, Object> regionList(String region_code, String parent_code) {
        Map<String, Object> retMap = new HashMap<>();
        if (StringUtils.isNotBlank(region_code)) {
            retMap = areaService.getRegionListMap(region_code);
        } else if (StringUtils.isNotBlank(parent_code)) {
            retMap = areaService.getRegionChildrenListMap(parent_code);
        }
        return retMap;
    }

    /**
     * 根据传入的ID集合，返回ID的收藏状态 {"code":0,"data":{"1811":"1","1800":"1"}}
     *
     * @param goods_ids
     * @return
     */
    @RequestMapping("/goods-collect-state")
    @ResponseBody
    public Ret goodsCollect(String goods_ids) {
        return Ret.me();
    }

    /**
     * * 根据传入的ID集合，返回ID的对比状态 {"code":0,"data":{"1811":"1","1800":"1"}}
     *
     * @param goods_ids
     * @return
     */
    @RequestMapping("/goods-compare-state")
    @ResponseBody
    public Ret goodsCompare(String goods_ids) {
        return Ret.me();
    }

    /**
     * 获取购物车数据
     */
    @RequestMapping("/cart/cart-data")
    @ResponseBody
    public Ret cartData() {
        TSso sso = SsoContext.getSso();
        Map<String, Object> cartData = new HashMap<>();
        if (null == sso) {
            cartData.put("goodsNumber", 0);
            cartData.put("goodsTotalPrice", 0);
        } else {
            //购物车数据
            cartData = cartService.cartsInfo();
        }
        return Ret.me().setData(cartData);
    }

}

