package com.yaorange.controller;

import com.yaorange.consts.ControllerConsts;
import com.yaorange.pojo.EUTreeNode;
import com.yaorange.pojo.TProductType;
import com.yaorange.service.ProductTypeService;
import com.yaorange.util.Ret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品类目
 */
@Controller
@RequestMapping("/" + ProductTypeController.DOMAIN)
public class ProductTypeController {
    public static final String DOMAIN = "productType";
    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 首页
     */
    @RequestMapping(value = ControllerConsts.URL_INDEX, method = RequestMethod.GET)
    public String index() {
        return DOMAIN + ControllerConsts.VIEW_INDEX;
    }

    /**
     * 编辑页面
     */
    @RequestMapping(value = ControllerConsts.URL_EDIT, method = RequestMethod.GET)
    public String edit() {
        return DOMAIN + ControllerConsts.VIEW_EDIT;
    }


    /**
     * 显示目录列表 /tree
     */
    @RequestMapping(value = ControllerConsts.URL_TREE_JSON, method = RequestMethod.GET)
    @ResponseBody
    public List<EUTreeNode> tree() {
        return productTypeService.getAllProductType();
    }

    /**
     * 新建条目列表
     */
    @RequestMapping(value = ControllerConsts.URL_STORE, method = RequestMethod.POST)
    @ResponseBody
    public Ret store(TProductType tProductType) {
        if (tProductType.getId() == null) {
            //保存
            productTypeService.save(tProductType);
        } else {
           //
        }
        return Ret.me();
    }


}
