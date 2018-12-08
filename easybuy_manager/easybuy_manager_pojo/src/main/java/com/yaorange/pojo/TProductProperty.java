package com.yaorange.pojo;

import java.io.Serializable;

public class TProductProperty implements Serializable {
    private Long id;

    private Long createTime;

    private Long productId;

    private Long propertyKeyId;

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
}