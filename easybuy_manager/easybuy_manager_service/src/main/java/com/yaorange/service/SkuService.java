package com.yaorange.service;

import com.yaorange.pojo.TPropertyKey;
import com.yaorange.pojo.TSku;

import java.util.List;

public interface SkuService {

	List<TPropertyKey> findPropertyKeys(Long productId,byte type);

    void save(TSku sku);

    List<TSku> findByProductId(Long productId);

    TSku findById(Long id);
    //通过skuCode获取sku信息
    TSku getSkuByCode(String skuCode);
}
