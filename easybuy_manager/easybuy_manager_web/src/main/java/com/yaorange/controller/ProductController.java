package com.yaorange.controller;

import com.yaorange.consts.ControllerConsts;
import com.yaorange.pojo.TProductExt;
import com.yaorange.pojo.TProductType;
import com.yaorange.service.impl.ProductServiceImpl;
import com.yaorange.util.Page;
import com.yaorange.util.Ret;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaorange.pojo.TProduct;
import com.yaorange.service.ProductService;

@Controller
@RequestMapping("/" + ProductController.DOMAIN)
public class ProductController {
    public static final String DOMAIN = "product";
    @Autowired
    private ProductService productService;
    private Logger logger = LoggerFactory.getLogger(ProductController.class);


    @RequestMapping("/{id}")
    @ResponseBody
    public TProduct queryProductId(@PathVariable long id) {
        return productService.queryProductId(id);
    }

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
    public String edit(Long id ,Model model) {
        if(id!=null) {
            TProductExt productExt = productService.findProductExtById(id);
            model.addAttribute("productExt", productExt);
        }
        return DOMAIN + ControllerConsts.VIEW_EDIT;
    }

    /**
     * 分页
     */
    @RequestMapping(value = ControllerConsts.URL_JSON, method = RequestMethod.GET)
    @ResponseBody
    public Page<TProduct> findByPage(Integer page, Integer rows) {
        return productService.findByPage(page, rows);
    }

    /**
     * 保存商品信息-->
     *
     * @param tProduct       商品基本信息、商品扩展信息、
     * @param resources      商品图片
     * @param propertyKeyIds 商品属性
     */
    @RequestMapping(value = ControllerConsts.URL_STORE, method = RequestMethod.POST)
    @ResponseBody
    public Ret store(TProduct tProduct, String[] resources, Long[] propertyKeyIds) {
        if(tProduct.getId()==null) {
            try {
                productService.save(tProduct, resources, propertyKeyIds);
                return Ret.me();
            } catch (Exception e) {
                logger.debug("发生错误：" + e.getMessage());
                logger.debug("已删除七牛云文件");
            }
            return Ret.me().setSuccess(false);
        }else {
            //todo 编辑
            return Ret.me();
        }
    }


    /**
     * 商品上架或者下架
     * @param ids  11,2,3
     * @param onsale 状态 1上架 0下架
     */
    @RequestMapping("/onSale")
    @ResponseBody
    public Ret onSaleOrOffSale(String ids,byte onsale){
        Boolean success = productService.updateProductState(ids,onsale);
        if(success) {
            return Ret.me();
        }
        return Ret.me().setSuccess(false);
    }
}
