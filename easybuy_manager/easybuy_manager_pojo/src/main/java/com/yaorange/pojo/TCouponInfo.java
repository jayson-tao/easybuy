package com.yaorange.pojo;

import java.io.Serializable;

public class TCouponInfo implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private String promotionName;

    private Long validateTime;

    private Integer totalCount;

    private Integer publishCount;

    private Integer leftCount;

    private Long promotionRuleid;

    private Long scopeRuleid;

    private String description;

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

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName == null ? null : promotionName.trim();
    }

    public Long getValidateTime() {
        return validateTime;
    }

    public void setValidateTime(Long validateTime) {
        this.validateTime = validateTime;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    public Integer getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(Integer leftCount) {
        this.leftCount = leftCount;
    }

    public Long getPromotionRuleid() {
        return promotionRuleid;
    }

    public void setPromotionRuleid(Long promotionRuleid) {
        this.promotionRuleid = promotionRuleid;
    }

    public Long getScopeRuleid() {
        return scopeRuleid;
    }

    public void setScopeRuleid(Long scopeRuleid) {
        this.scopeRuleid = scopeRuleid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}