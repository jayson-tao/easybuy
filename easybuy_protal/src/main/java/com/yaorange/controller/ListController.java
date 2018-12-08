package com.yaorange.controller;

import java.util.Map;

import com.yaorange.mapper.TSsoMapper;
import com.yaorange.pojo.TSso;
import com.yaorange.service.ProductSkuService;
import com.yaorange.utils.SsoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaorange.query.ProductQuery;
import com.yaorange.service.EsService;
import com.yaorange.util.Page;

@Controller
public class ListController {
    @Autowired
    private EsService esService;
    @Autowired
    private ProductSkuService productSkuService;
    @Autowired
    private TSsoMapper ssoMapper;

    /**
     * 收索
     */
    @RequestMapping("/list")
    public String list(ProductQuery query, Model model) {
        Page<Map<String, Object>> queryFromEs = esService.queryFromEs(query);
        model.addAttribute("page", queryFromEs);
        return "list";
    }

    @RequestMapping("/p/{id}")
    public String productDetail(@PathVariable Long id,Model model){
        //模拟用户登录放到session中
        TSso sso = ssoMapper.selectByPrimaryKey(18L);
        SsoContext.setSso(sso);
        productSkuService.findSkuByProductId(id,model);
        return "p";
    }

}
