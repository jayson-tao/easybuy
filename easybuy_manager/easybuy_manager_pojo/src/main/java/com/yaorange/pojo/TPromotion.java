package com.yaorange.pojo;

import java.io.Serializable;

public class TPromotion implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private String promotionName;

    private String icon;

    private Byte isOpen;

    private Long scopeRuleId;

    private Long promotionRuleId;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Byte getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Byte isOpen) {
        this.isOpen = isOpen;
    }

    public Long getScopeRuleId() {
        return scopeRuleId;
    }

    public void setScopeRuleId(Long scopeRuleId) {
        this.scopeRuleId = scopeRuleId;
    }

    public Long getPromotionRuleId() {
        return promotionRuleId;
    }

    public void setPromotionRuleId(Long promotionRuleId) {
        this.promotionRuleId = promotionRuleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}