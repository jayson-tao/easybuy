package com.yaorange.service;

import com.yaorange.pojo.TProduct;
import com.yaorange.pojo.TProductExt;
import com.yaorange.util.Page;

public interface ProductService {
	 TProduct queryProductId(long id);
	Page<TProduct> findByPage(Integer page, Integer rows);

    void save(TProduct tProduct, String[] resources, Long[] propertyKeyIds);

    TProductExt findProductExtById(Long id);
    //上架或下架
    Boolean updateProductState(String ids, Byte onSale);
}
