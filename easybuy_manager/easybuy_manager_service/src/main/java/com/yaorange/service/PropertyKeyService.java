package com.yaorange.service;

import com.yaorange.pojo.TPropertyKey;

import java.util.List;

public interface PropertyKeyService {

    List<TPropertyKey> getProperKey(Long productType);

    void save(TPropertyKey propertyKey);
}
