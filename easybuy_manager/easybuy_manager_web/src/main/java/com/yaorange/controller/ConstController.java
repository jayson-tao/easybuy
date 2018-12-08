package com.yaorange.controller;


import com.yaorange.consts.ConstUtils;
import com.yaorange.consts.bis.PropertyInputModeConsts;
import com.yaorange.consts.bis.PropertyInputTypeConsts;
import com.yaorange.util.KV;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/const")
public class ConstController {

    @RequestMapping("/propertyInputMode")
    @ResponseBody
    public List<KV<Integer,String>> getInputMode() {
        List<KV<Integer, String>> kvs = ConstUtils.getKvList(PropertyInputModeConsts.class);
        return kvs;
    }

    @RequestMapping("/propertyInputType")
    @ResponseBody
    public List<KV<Integer,String>> getInputType() {
        List<KV<Integer, String>> kvs = ConstUtils.getKvList(PropertyInputTypeConsts.class);
        return kvs;
    }

}
