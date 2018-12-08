package com.yaorange.pojo;

import java.io.Serializable;

public class TPayInteraction implements Serializable {
    private Long id;

    private Long updateTime;

    private Long createTime;

    private String unionPaySn;

    private Long payBillId;

    private Byte payChannel;

    private Integer money;

    private String returnSeq;

    private Integer returnMoney;

    private Long notifyTime;

    private Byte state;

    private String reactionData;

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

    public String getUnionPaySn() {
        return unionPaySn;
    }

    public void setUnionPaySn(String unionPaySn) {
        this.unionPaySn = unionPaySn == null ? null : unionPaySn.trim();
    }

    public Long getPayBillId() {
        return payBillId;
    }

    public void setPayBillId(Long payBillId) {
        this.payBillId = payBillId;
    }

    public Byte getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Byte payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getReturnSeq() {
        return returnSeq;
    }

    public void setReturnSeq(String returnSeq) {
        this.returnSeq = returnSeq == null ? null : returnSeq.trim();
    }

    public Integer getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Integer returnMoney) {
        this.returnMoney = returnMoney;
    }

    public Long getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Long notifyTime) {
        this.notifyTime = notifyTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getReactionData() {
        return reactionData;
    }

    public void setReactionData(String reactionData) {
        this.reactionData = reactionData == null ? null : reactionData.trim();
    }
}