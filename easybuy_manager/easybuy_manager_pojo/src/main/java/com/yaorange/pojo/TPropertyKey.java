package com.yaorange.pojo;

import java.io.Serializable;

public class TPropertyKey implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private String propertyKey;

    private Long productType;

    private Byte type;

    private Byte inputMode;

    private Byte inputType;

    private String validatePattern;

    private String remark;

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

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey == null ? null : propertyKey.trim();
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getInputMode() {
        return inputMode;
    }

    public void setInputMode(Byte inputMode) {
        this.inputMode = inputMode;
    }

    public Byte getInputType() {
        return inputType;
    }

    public void setInputType(Byte inputType) {
        this.inputType = inputType;
    }

    public String getValidatePattern() {
        return validatePattern;
    }

    public void setValidatePattern(String validatePattern) {
        this.validatePattern = validatePattern == null ? null : validatePattern.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}