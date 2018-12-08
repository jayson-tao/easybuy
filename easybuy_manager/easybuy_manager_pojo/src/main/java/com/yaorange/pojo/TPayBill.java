package com.yaorange.pojo;

import java.io.Serializable;

public class TPayBill implements Serializable {
    private Long id;

    private Long updateTime;

    private Long createTime;

    private Long ssoId;

    private String nickName;

    private String unionPaySn;

    private Integer money;

    private Byte businessType;

    private Long businessKey;

    private Byte payChannel;

    private String note;

    private String digest;

    private Byte state;

    private Long originalPayBillId;

    private String originalUnionPaySn;

    private Long lastPayTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUnionPaySn() {
        return unionPaySn;
    }

    public void setUnionPaySn(String unionPaySn) {
        this.unionPaySn = unionPaySn == null ? null : unionPaySn.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(Long businessKey) {
        this.businessKey = businessKey;
    }

    public Byte getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Byte payChannel) {
        this.payChannel = payChannel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getOriginalPayBillId() {
        return originalPayBillId;
    }

    public void setOriginalPayBillId(Long originalPayBillId) {
        this.originalPayBillId = originalPayBillId;
    }

    public String getOriginalUnionPaySn() {
        return originalUnionPaySn;
    }

    public void setOriginalUnionPaySn(String originalUnionPaySn) {
        this.originalUnionPaySn = originalUnionPaySn == null ? null : originalUnionPaySn.trim();
    }

    public Long getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(Long lastPayTime) {
        this.lastPayTime = lastPayTime;
    }
}