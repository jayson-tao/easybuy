package com.yaorange.pojo;

import java.io.Serializable;

public class TPropertyValue implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long propertyKeyId;

    private String propertyValue;

    private String optionPic;

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

    public Long getPropertyKeyId() {
        return propertyKeyId;
    }

    public void setPropertyKeyId(Long propertyKeyId) {
        this.propertyKeyId = propertyKeyId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue == null ? null : propertyValue.trim();
    }

    public String getOptionPic() {
        return optionPic;
    }

    public void setOptionPic(String optionPic) {
        this.optionPic = optionPic == null ? null : optionPic.trim();
    }
}