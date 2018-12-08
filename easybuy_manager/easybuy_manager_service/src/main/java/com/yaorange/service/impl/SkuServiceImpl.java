package com.yaorange.service.impl;

import com.yaorange.mapper.TProductMapper;
import com.yaorange.mapper.TPropertyKeyMapper;
import com.yaorange.mapper.TSkuMapper;
import com.yaorange.mapper.TSkuPropertyMapper;
import com.yaorange.pojo.*;
import com.yaorange.service.SkuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private TPropertyKeyMapper propertyKeyMapper;
    @Autowired
    private TSkuMapper skuMapper;
    @Autowired
    private TProductMapper productMapper;
    @Autowired
    private TSkuPropertyMapper skuPropertyMapper;

    @Override
    public TSku getSkuByCode(String skuCode) {
        TSku sku = null;
        TSkuExample example = new TSkuExample();
        example.createCriteria().andSkuCodeEqualTo(skuCode);
        List<TSku> tSkus = skuMapper.selectByExample(example);
        if(tSkus!=null&&tSkus.size()>0){
            sku = tSkus.get(0);
        }
        return sku;
    }

    /**
     * 根据id查询sku
     */
    @Override
    public TSku findById(Long id) {
        TSku sku = skuMapper.selectByPrimaryKey(id);
        String properties = sku.getSkuProperties();
        //39:尺码:75:L_36:颜色:72:宝蓝色--keyId-keyValue-valueId-value
        String[] split = properties.split("_");
        List<TSkuProperty> propertyList = sku.getSkuPropertyList();
        handler(split, propertyList);
        return sku;
    }

    /**
     * 包装数据工具类
     *
     * @param split
     * @param propertyList
     * @return
     */
    public List<TSkuProperty> handler(String[] split, List<TSkuProperty> propertyList) {
        for (String s : split) {
            TSkuProperty property = new TSkuProperty();
            String[] split1 = s.split(":");
            property.setPropertyKeyId(Long.valueOf(split1[0]));
            property.setPropertyKey(split1[1]);
            property.setPropertyValueId(Long.valueOf(split1[2]));
            property.setPropertyValue(split1[3]);
            propertyList.add(property);
        }
        return propertyList;
    }

    /**
     * 查询所有sku
     */
    @Override
    public List<TSku> findByProductId(Long productId) {
        TSkuExample example = new TSkuExample();
        TSkuExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdEqualTo(productId);
        List<TSku> list = skuMapper.selectByExample(example);
        //封装tskuProperty
        for (TSku sku : list) {
            String properties = sku.getSkuProperties();
            //39:尺码:75:L_36:颜色:72:宝蓝色--keyId-keyValue-valueId-value
            String[] split = properties.split("_");
            List<TSkuProperty> propertyList = sku.getSkuPropertyList();
            handler(split, propertyList);
        }
        return list;
    }


    /**
     * 保存sku
     * -》sku  sku_property
     */
    @Override
    public void save(TSku sku) {
        sku.setCreateTime(System.currentTimeMillis());
        sku.setUpdateTime(System.currentTimeMillis());
        //保存sku表
        //设置skucode ->根据productId找到code 如果为null 表示还没有一条sku记录，如果有设置code+1
        Long productId = sku.getProductId();
        String code = skuMapper.selectMaxSkuCodeByProductId(productId);
        long newCode;
        if (StringUtils.isNotEmpty(code)) {
            //说明是数据库最大code
            long oldCode = Long.parseLong(code);
            //加一设置给新增的sku
            newCode = oldCode + 1;
        } else {
            //如果为null据去查product表的code
            code = productMapper.selectByPrimaryKey(productId).getCode();
            newCode = Long.parseLong(code) + 1;
        }
        //设置skucode
        sku.setSkuCode(newCode + "");
        //设置冗余字段的信息 key value
        List<TSkuProperty> list = sku.getSkuPropertyList();
        StringBuffer sb = new StringBuffer();
        for (TSkuProperty p : list) {
            sb.append(p.getPropertyKeyId() + ":" + p.getPropertyKey() + ":" + p.getPropertyValueId() + ":" + p.getPropertyValue() + "_");
        }
        //去掉最后一个"_"
        String properties = sb.toString().substring(0, sb.length() - 1);
        sku.setSkuProperties(properties);
        sku.setMarketPrice(sku.getMarketPrice() * 100);
        sku.setPrice(sku.getPrice() * 100);
        sku.setCostPrice(sku.getCostPrice() * 100);
        skuMapper.insert(sku);
        //保存sku_property
        List<TSkuProperty> propertyList = sku.getSkuPropertyList();
        for (TSkuProperty property : propertyList) {
            property.setSkuId(sku.getId());
        }
        //批量插入
        skuPropertyMapper.insertBatch(propertyList);
        //更新商品的最高最低价格
        skuMapper.updateProductPrice(sku.getId(), sku.getProductId());
    }

    /**
     * 查询商品对应的属性
     *
     * @param productId
     * @param type      1-》销售 0-》显示
     * @return
     */
    @Override
    public List<TPropertyKey> findPropertyKeys(Long productId, byte type) {
        return propertyKeyMapper.findPropertyKeys(productId, type);
    }
}
