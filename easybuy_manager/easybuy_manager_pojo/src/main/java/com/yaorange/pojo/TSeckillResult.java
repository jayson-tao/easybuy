package com.yaorange.pojo;

import java.io.Serializable;

public class TSeckillResult implements Serializable {
    private Long id;

    private Long createTime;

    private Long seckillSkuId;

    private Integer totalCount;

    private Long ssoId;

    private Long lastConfirmTime;

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

    public Long getSeckillSkuId() {
        return seckillSkuId;
    }

    public void setSeckillSkuId(Long seckillSkuId) {
        this.seckillSkuId = seckillSkuId;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Long getSsoId() {
        return ssoId;
    }

    public void setSsoId(Long ssoId) {
        this.ssoId = ssoId;
    }

    public Long getLastConfirmTime() {
        return lastConfirmTime;
    }

    public void setLastConfirmTime(Long lastConfirmTime) {
        this.lastConfirmTime = lastConfirmTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}