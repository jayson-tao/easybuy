package com.yaorange.controller;

import com.yaorange.consts.bis.PropertyTypeConsts;
import com.yaorange.pojo.TPropertyKey;
import com.yaorange.pojo.TSku;
import com.yaorange.pojo.TSkuProperty;
import com.yaorange.service.SkuService;
import com.yaorange.util.Ret;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/" + SkuController.DOMAIN)
public class SkuController {
    public static final String DOMAIN = "product";
    @Autowired
    private SkuService skuService;

    @RequestMapping("/skus")
    public String getSkus(Long productId, Model model) {
        //查询当前商品的所有销售属性
        List<TPropertyKey> propertyKeys = skuService.findPropertyKeys(productId, PropertyTypeConsts.PROPERTY_SALE);
        //查询当前商品的sku
        List<TSku> list=skuService.findByProductId(productId);
        model.addAttribute("propertyKeys", propertyKeys);
        model.addAttribute("productId", productId);
        model.addAttribute("skuList", list);
        return DOMAIN + "/skus";
    }

    /**
     * 保存
     *
     * @param sku
     * @param propertyKeyId   keyIds
     * @param propertyValueId valueIds
     * @param propertyValue   values
     * @param propertyKey
     */
    @RequestMapping("/storeSku")
    @ResponseBody
    public Ret store(TSku sku, Long[] propertyKeyId, String[] propertyKey, Long[] propertyValueId, String[] propertyValue) {
        if (propertyKeyId != null && propertyKey != null && propertyKeyId != null && propertyValue != null) {
            if(propertyKey.length==propertyKeyId.length&&propertyKeyId.length==propertyValueId.length&&propertyKeyId.length==propertyValueId.length) {
                //封装数据
                List<TSkuProperty> list = sku.getSkuPropertyList();
                for (int i = 0; i < propertyKey.length; i++) {
                    //封装skuproperty
                    TSkuProperty skuProperty = new TSkuProperty();
                    skuProperty.setCreateTime(System.currentTimeMillis());
                    skuProperty.setUpdateTime(System.currentTimeMillis());
                    skuProperty.setPropertyKeyId(propertyKeyId[i]);
                    skuProperty.setPropertyKey(propertyKey[i]);
                    skuProperty.setPropertyValueId(propertyValueId[i]);
                    skuProperty.setPropertyValue(propertyValue[i]);
                    list.add(skuProperty);
                }
                //调用业务方法
                skuService.save(sku);
            }
            return Ret.me();
        }
        return Ret.me().setSuccess(false);
    }

    /**
     * 编辑
     */
    @RequestMapping("/sku/{id}")
    @ResponseBody
    public TSku edit(@PathVariable Long id){
       //返回list
        TSku tSku = skuService.findById(id);
        return tSku;
    }
}
