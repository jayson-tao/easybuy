package com.yaorange.controller;

import com.yaorange.consts.ControllerConsts;
import com.yaorange.pojo.TPropertyKey;
import com.yaorange.service.PropertyKeyService;
import com.yaorange.util.Ret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/" + PropertyKeyController.DOMAIN)
public class PropertyKeyController {
    public static final String DOMAIN = "propertyKey";
    @Autowired
    private PropertyKeyService propertyKeyService;

    /**
     * 菜单主页
     */
    @RequestMapping(value = "/propertyManage", method = RequestMethod.GET)
    public String propertyManage() {
        return DOMAIN + "/propertyManage";
    }

    /**
     * 编辑
     */
    @RequestMapping(value = ControllerConsts.URL_EDIT, method = RequestMethod.GET)
    public String edit() {
        return DOMAIN + ControllerConsts.VIEW_EDIT;
    }

    /**
     * 显示
     */
    @RequestMapping(value = ControllerConsts.URL_SHOW, method = RequestMethod.GET)
    public String show() {
        return DOMAIN + ControllerConsts.VIEW_SHOW;
    }

    /**
     * 请求对应商品条目的key值
     *
     * @param productType 商品条目id
     */
    @RequestMapping("/" + ControllerConsts.URL_JSON)
    @ResponseBody
    public List<TPropertyKey> getProperKey(Long productType) {
        if (productType == null) {
            return null;
        }
        List<TPropertyKey> keyList = propertyKeyService.getProperKey(productType);
        return keyList;
    }

    /**
     * 保存条目key
     */
    @RequestMapping(value = ControllerConsts.URL_STORE,method = RequestMethod.POST)
    @ResponseBody
    public Ret store(TPropertyKey propertyKey) {
        propertyKeyService.save(propertyKey);
        return Ret.me();
    }
}
