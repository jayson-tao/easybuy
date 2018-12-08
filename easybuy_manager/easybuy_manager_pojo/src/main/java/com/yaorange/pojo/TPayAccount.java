package com.yaorange.pojo;

import java.io.Serializable;

public class TPayAccount implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long ssoId;

    private Integer useableBalance;

    private Integer frozenBalance;

    private Integer creditBanance;

    private String payPassword;

    private Integer couponCount;

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

    public Long getSsoId() {
        return ssoId;
    }

    public void setSsoId(Long ssoId) {
        this.ssoId = ssoId;
    }

    public Integer getUseableBalance() {
        return useableBalance;
    }

    public void setUseableBalance(Integer useableBalance) {
        this.useableBalance = useableBalance;
    }

    public Integer getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(Integer frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public Integer getCreditBanance() {
        return creditBanance;
    }

    public void setCreditBanance(Integer creditBanance) {
        this.creditBanance = creditBanance;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }
}