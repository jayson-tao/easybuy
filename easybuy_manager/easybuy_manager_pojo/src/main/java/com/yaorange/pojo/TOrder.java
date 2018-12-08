package com.yaorange.pojo;

import java.io.Serializable;
import java.util.List;

public class TOrder implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long ssoId;

    private String orderSn;

    private Long storeId;

    private String storeName;

    private String leaveword;

    private Byte state;

    private Integer carriageFee;

    private String remark;

    private Integer totalMoney;

    private String discountMoney;

    private Integer realMoney;

    private Integer payMoney;

    private Byte payChannel;

    private Long payTime;

    private Long couponId;

    private Integer couponMoney;

    private Long promotionId;

    private Integer promotionMoney;

    private Byte orderFrom;

    private Long finishedTime;

    private Byte commentStatus;

    private Long commentTime;

    private Long shipStore;

    private String shipSn;

    private String shipTime;

    private Long shipSendTime;

    private String digest;

    private Byte saleReturnState;

    private String returnOrderSn;

    private String changeOrderSn;

    private Byte needBill;

    private Long lastPayTime;

    private Long lastConfirmShipTime;

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

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getLeaveword() {
        return leaveword;
    }

    public void setLeaveword(String leaveword) {
        this.leaveword = leaveword == null ? null : leaveword.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getCarriageFee() {
        return carriageFee;
    }

    public void setCarriageFee(Integer carriageFee) {
        this.carriageFee = carriageFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(String discountMoney) {
        this.discountMoney = discountMoney == null ? null : discountMoney.trim();
    }

    public Integer getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(Integer realMoney) {
        this.realMoney = realMoney;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    //订单地址
    private TOrderAddress orderAddress;
    //订单详情
    private List<TOrderDetail> detailList;

    public TOrderAddress getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(TOrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<TOrderDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<TOrderDetail> detailList) {
        this.detailList = detailList;
    }

    public Byte getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Byte payChannel) {
        this.payChannel = payChannel;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Integer getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Integer couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getPromotionMoney() {
        return promotionMoney;
    }

    public void setPromotionMoney(Integer promotionMoney) {
        this.promotionMoney = promotionMoney;
    }

    public Byte getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Byte orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Long getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Long finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Long getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Long commentTime) {
        this.commentTime = commentTime;
    }

    public Long getShipStore() {
        return shipStore;
    }

    public void setShipStore(Long shipStore) {
        this.shipStore = shipStore;
    }

    public String getShipSn() {
        return shipSn;
    }

    public void setShipSn(String shipSn) {
        this.shipSn = shipSn == null ? null : shipSn.trim();
    }

    public String getShipTime() {
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime == null ? null : shipTime.trim();
    }

    public Long getShipSendTime() {
        return shipSendTime;
    }

    public void setShipSendTime(Long shipSendTime) {
        this.shipSendTime = shipSendTime;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public Byte getSaleReturnState() {
        return saleReturnState;
    }

    public void setSaleReturnState(Byte saleReturnState) {
        this.saleReturnState = saleReturnState;
    }

    public String getReturnOrderSn() {
        return returnOrderSn;
    }

    public void setReturnOrderSn(String returnOrderSn) {
        this.returnOrderSn = returnOrderSn == null ? null : returnOrderSn.trim();
    }

    public String getChangeOrderSn() {
        return changeOrderSn;
    }

    public void setChangeOrderSn(String changeOrderSn) {
        this.changeOrderSn = changeOrderSn == null ? null : changeOrderSn.trim();
    }

    public Byte getNeedBill() {
        return needBill;
    }

    public void setNeedBill(Byte needBill) {
        this.needBill = needBill;
    }

    public Long getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(Long lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public Long getLastConfirmShipTime() {
        return lastConfirmShipTime;
    }

    public void setLastConfirmShipTime(Long lastConfirmShipTime) {
        this.lastConfirmShipTime = lastConfirmShipTime;
    }
}
