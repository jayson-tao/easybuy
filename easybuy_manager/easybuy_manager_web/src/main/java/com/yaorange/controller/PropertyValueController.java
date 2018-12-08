package com.yaorange.controller;

import com.yaorange.consts.ControllerConsts;
import com.yaorange.pojo.TPropertyKey;
import com.yaorange.pojo.TPropertyValue;
import com.yaorange.service.PropertyValueService;
import com.yaorange.util.Ret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/" + PropertyValueController.DOMAIN)
public class PropertyValueController {
    public static final String DOMAIN = "propertyValue";
    @Autowired
    private PropertyValueService propertyValueService;


    @RequestMapping(value = ControllerConsts.URL_EDIT, method = RequestMethod.GET)
    public String edit() {
        return DOMAIN + ControllerConsts.VIEW_EDIT;
    }

    @RequestMapping(value = ControllerConsts.URL_SHOW, method = RequestMethod.GET)
    public String show(Long id) {

        return DOMAIN + ControllerConsts.VIEW_SHOW;
    }


    /**
     * 请求对应商品条目的key值
     *
     * @param propertyKeyId
     */
    @RequestMapping("/" + ControllerConsts.URL_JSON)
    @ResponseBody
    public List<TPropertyValue> getProperKey(Long propertyKeyId) {
        if(propertyKeyId==null){
            return null;
        }
        List<TPropertyValue> keyList = propertyValueService.getProperValue(propertyKeyId);
        return keyList;
    }


    /**
     * 保存条目value
     */
    @RequestMapping(value = ControllerConsts.URL_STORE,method = RequestMethod.POST)
    @ResponseBody
    public Ret store(TPropertyValue propertyValue) {
        propertyValueService.save(propertyValue);
        return Ret.me();
    }
}
