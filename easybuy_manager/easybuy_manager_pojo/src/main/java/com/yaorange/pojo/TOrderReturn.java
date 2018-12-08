package com.yaorange.pojo;

import java.io.Serializable;

public class TOrderReturn implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long orderId;

    private String orderSn;

    private String returnSn;

    private Long applyTime;

    private Integer totalMoney;

    private Integer carriageFee;

    private Integer realMoney;

    private Integer returnPayMoney;

    private Long ssoId;

    private String reason;

    private Byte payChannel;

    private Byte state;

    private String remark;

    private Long returnShipStore;

    private String returnShipSn;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public String getReturnSn() {
        return returnSn;
    }

    public void setReturnSn(String returnSn) {
        this.returnSn = returnSn == null ? null : returnSn.trim();
    }

    public Long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getCarriageFee() {
        return carriageFee;
    }

    public void setCarriageFee(Integer carriageFee) {
        this.carriageFee = carriageFee;
    }

    public Integer getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(Integer realMoney) {
        this.realMoney = realMoney;
    }

    public Integer getReturnPayMoney() {
        return returnPayMoney;
    }

    public void setReturnPayMoney(Integer returnPayMoney) {
        this.returnPayMoney = returnPayMoney;
    }

    public Long getSsoId() {
        return ssoId;
    }

    public void setSsoId(Long ssoId) {
        this.ssoId = ssoId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Byte getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Byte payChannel) {
        this.payChannel = payChannel;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getReturnShipStore() {
        return returnShipStore;
    }

    public void setReturnShipStore(Long returnShipStore) {
        this.returnShipStore = returnShipStore;
    }

    public String getReturnShipSn() {
        return returnShipSn;
    }

    public void setReturnShipSn(String returnShipSn) {
        this.returnShipSn = returnShipSn == null ? null : returnShipSn.trim();
    }
}