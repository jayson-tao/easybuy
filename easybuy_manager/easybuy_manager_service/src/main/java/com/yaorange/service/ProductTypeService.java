package com.yaorange.service;

import com.yaorange.pojo.EUTreeNode;
import com.yaorange.pojo.TProduct;
import com.yaorange.pojo.TProductType;
import com.yaorange.util.Page;

import java.util.List;

public interface ProductTypeService {
    //返回所有商品条目
    List<EUTreeNode>  getAllProductType();

    void save(TProductType tProductType);

}
