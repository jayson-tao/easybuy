package com.yaorange.service;

import java.util.List;
import java.util.Map;

import com.yaorange.pojo.TVipCart;
import com.yaorange.util.Ret;

public interface CartService {

    Map<String, Object> cartsInfo();

    void add2Cart(Integer number, Long skuId);

    Ret cartSelect(String cartIds);

    Map<String, Object> selectedSku();

    List<TVipCart> queryVipCarts();


}
