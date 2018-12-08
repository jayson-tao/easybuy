package com.yaorange.pojo;

import java.io.Serializable;

public class TProductViewProperty implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long productId;

    private Long propertyKeyId;

    private String propertyKey;

    private Long propertyValueId;

    private String propertyValue;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPropertyKeyId() {
        return propertyKeyId;
    }

    public void setPropertyKeyId(Long propertyKeyId) {
        this.propertyKeyId = propertyKeyId;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey == null ? null : propertyKey.trim();
    }

    public Long getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(Long propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue == null ? null : propertyValue.trim();
    }
}