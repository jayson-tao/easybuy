package com.yaorange.pojo;

import java.io.Serializable;

public class TCoupon implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long couponId;

    private Long validateTime;

    private Long scopeRules;

    private Long promotionRules;

    private Byte state;

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

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getValidateTime() {
        return validateTime;
    }

    public void setValidateTime(Long validateTime) {
        this.validateTime = validateTime;
    }

    public Long getScopeRules() {
        return scopeRules;
    }

    public void setScopeRules(Long scopeRules) {
        this.scopeRules = scopeRules;
    }

    public Long getPromotionRules() {
        return promotionRules;
    }

    public void setPromotionRules(Long promotionRules) {
        this.promotionRules = promotionRules;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}