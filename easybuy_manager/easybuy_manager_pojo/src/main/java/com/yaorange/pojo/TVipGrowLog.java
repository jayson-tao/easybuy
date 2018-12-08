package com.yaorange.pojo;

import java.io.Serializable;

public class TVipGrowLog implements Serializable {
    private Long id;

    private Long createTime;

    private Long ssoId;

    private String fromReason;

    private Integer score;

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

    public Long getSsoId() {
        return ssoId;
    }

    public void setSsoId(Long ssoId) {
        this.ssoId = ssoId;
    }

    public String getFromReason() {
        return fromReason;
    }

    public void setFromReason(String fromReason) {
        this.fromReason = fromReason == null ? null : fromReason.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}