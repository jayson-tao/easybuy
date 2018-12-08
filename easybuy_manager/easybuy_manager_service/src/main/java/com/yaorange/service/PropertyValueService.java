package com.yaorange.service;

import com.yaorange.pojo.TPropertyValue;

import java.util.List;

public interface PropertyValueService {

    List<TPropertyValue> getProperValue(Long propertyKeyId);

    void save(TPropertyValue propertyValue);
}
