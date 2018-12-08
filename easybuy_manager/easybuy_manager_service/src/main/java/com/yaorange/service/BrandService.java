package com.yaorange.service;

import com.yaorange.pojo.TBrand;
import com.yaorange.util.Page;

import java.util.List;

public interface BrandService {
	Page<TBrand> findByPage(Integer page, Integer rows);


    List<TBrand> findByKeyword(String q);

    void save(TBrand brand);

    void update(TBrand brand);

    TBrand findById(Long id);
}
