package com.yaorange.service.impl;

import com.yaorange.mapper.TPropertyKeyMapper;
import com.yaorange.mapper.TPropertyValueMapper;
import com.yaorange.pojo.TPropertyValue;
import com.yaorange.pojo.TPropertyValueExample;
import com.yaorange.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    private TPropertyValueMapper propertyValueMapper;

    /**
     * 保存条目value
     * @param propertyValue
     */
    @Override
    public void save(TPropertyValue propertyValue) {
        propertyValue.setCreateTime(System.currentTimeMillis());
        propertyValueMapper.insert(propertyValue);
    }

    /**
     * 根据keyid在value表中找到对应的value
     * @param propertyKeyId
     */
    @Override
    public List<TPropertyValue> getProperValue(Long propertyKeyId) {
        TPropertyValueExample example = new TPropertyValueExample();
        TPropertyValueExample.Criteria criteria = example.createCriteria();
        criteria.andPropertyKeyIdEqualTo(propertyKeyId);
        List<TPropertyValue> propertyValues = propertyValueMapper.selectByExample(example);
        return propertyValues;
    }
}
