package com.yaorange.service.impl;

import com.yaorange.mapper.TPropertyKeyMapper;
import com.yaorange.pojo.TPropertyKey;
import com.yaorange.pojo.TPropertyKeyExample;
import com.yaorange.service.PropertyKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyKeyServiceImpl implements PropertyKeyService {
    @Autowired
    private TPropertyKeyMapper propertyKeyMapper;

    /**
     * 保存条目可以属性
     */
    @Override
    public void save(TPropertyKey propertyKey) {
        propertyKey.setCreateTime(System.currentTimeMillis());
        propertyKeyMapper.insert(propertyKey);
    }

    /**
     * @param productType 条目id
     */
    @Override
    public List<TPropertyKey> getProperKey(Long productType) {
        TPropertyKeyExample example = new TPropertyKeyExample();
        TPropertyKeyExample.Criteria criteria = example.createCriteria();
        criteria.andProductTypeEqualTo(productType);
        List<TPropertyKey> propertyKeys = propertyKeyMapper.selectByExample(example);
        return propertyKeys;
    }
}
