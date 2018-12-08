package com.yaorange.controller;

import com.yaorange.consts.ControllerConsts;
import com.yaorange.pojo.TBrand;
import com.yaorange.pojo.TProduct;
import com.yaorange.service.BrandService;
import com.yaorange.util.Page;
import com.yaorange.util.Ret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/" + BrandController.DOMAIN)
public class BrandController {
    public static final String DOMAIN = "brand";
    @Autowired
    private BrandService brandService;

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
     * 分页
     */
    @RequestMapping(value = ControllerConsts.URL_JSON, method = RequestMethod.GET)
    @ResponseBody
    public Page<TBrand> findByPage(Integer page, Integer rows) {
        return brandService.findByPage(page, rows);
    }

    /**
     * 模糊查询
     *
     * @param q 品牌因为字母
     */
    @RequestMapping("/data")
    @ResponseBody
    public List<TBrand> findByKeyword(String q) {

        return brandService.findByKeyword(q);
    }

    /**
     * 保存
     */
    @RequestMapping(ControllerConsts.URL_STORE)
    @ResponseBody
    public Ret store(TBrand brand) {
        if (brand.getId() == null) {
            brandService.save(brand);
        } else {
            brandService.update(brand);
        }
        return Ret.me();
    }

    @RequestMapping("/detail")
    @ResponseBody
    public TBrand edit(Long id) {
        return brandService.findById(id);
    }
}
