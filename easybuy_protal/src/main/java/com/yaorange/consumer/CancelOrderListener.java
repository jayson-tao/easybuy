package com.yaorange.consumer;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

import com.yaorange.consts.bis.OrderStateConsts;
import com.yaorange.mapper.TOrderDetailMapper;
import com.yaorange.mapper.TOrderMapper;
import com.yaorange.mapper.TSkuMapper;
import com.yaorange.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.yaorange.consts.bis.PayBillBusinessTypeConsts;
import com.yaorange.consts.bis.PayStateConsts;
import com.yaorange.mapper.TPayBillMapper;
import com.yaorange.service.PayService;
import com.yaorange.util.CodeGenerateUtils;
import com.yaorange.utils.AliPayUtils;

import java.util.List;

/**
 * 取消订单消费者
 */
public class CancelOrderListener implements MessageListener {

    @Autowired
    private PayService payService;
    @Autowired
    private TPayBillMapper payBillMapper;
    @Autowired
    private TOrderDetailMapper orderDetailMapper;
    @Autowired
    private TSkuMapper skuMapper;

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination cancelOrderConfirmQueue;
    private long orderId;

    /**
     * 消费消息
     *
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = (MapMessage) message;
        try {
            orderId = mapMessage.getLong("orderId");
            cancelOrder(orderId);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        jmsTemplate.send(cancelOrderConfirmQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setLong("orderId", orderId);
                mapMessage.setBoolean("success", true);
                return mapMessage;
            }
        });
    }

    /**
     * 取消订单
     *
     * @param orderId
     */
    public void cancelOrder(long orderId) {
        TPayBill payBill = payService.queryPayBillByOrderId(orderId);
        //未付款的情况
        if (payBill.getState() == PayStateConsts.WAIT_PAY) {
            //关闭支付宝交易
            AliPayUtils.closeTrade(payBill.getUnionPaySn());
            payBill.setState(PayStateConsts.FAIL);
            payBillMapper.updateByPrimaryKeySelective(payBill);
            //改库存
            changeSkuAmount(orderId);
        }
        //已经支付
        if (payBill.getState() == PayStateConsts.PAYED) {
            boolean refund = AliPayUtils.refund(payBill.getUnionPaySn(), payBill.getMoney(), "7天不爽", null);
            if (refund) {
                changeSkuAmount(orderId);
                refund(payBill);
            }
        }
    }

    private void refund(TPayBill payBill) {
        // 这里新创建一个退款支付单
        TPayBill cancelPayBill = new TPayBill();
        cancelPayBill.setCreateTime(System.currentTimeMillis());
        cancelPayBill.setUpdateTime(cancelPayBill.getCreateTime());
        cancelPayBill.setSsoId(payBill.getSsoId());
        String digest = "订单取消退款" + payBill.getUnionPaySn();
        cancelPayBill.setLastPayTime(System.currentTimeMillis());
        cancelPayBill.setDigest(digest);
        cancelPayBill.setMoney(payBill.getMoney());// 支付金额
        cancelPayBill.setNote(digest);
        cancelPayBill.setPayChannel(payBill.getPayChannel());
        cancelPayBill.setState(PayStateConsts.PAYED);
        cancelPayBill.setOriginalPayBillId(payBill.getId());
        cancelPayBill.setOriginalUnionPaySn(payBill.getUnionPaySn());

        String unionPaySn = CodeGenerateUtils.generateUnionPaySn();// 统一支付单号
        cancelPayBill.setUnionPaySn(unionPaySn);
        cancelPayBill.setBusinessKey(payBill.getBusinessKey());
        cancelPayBill.setBusinessType(PayBillBusinessTypeConsts.ORDER_CANCEL);
        payBillMapper.insert(cancelPayBill);
        //创建退款流水
        //发送退款短信通知
        System.out.println("您的易购网退款将于7个工作日内原路返回，请注意查收，退款金额：" + (payBill.getMoney() * 0.01) + "元");
    }

    public void changeSkuAmount(long orderId) {
        //查询订单详情 -
        TOrderDetailExample example = new TOrderDetailExample();
        TOrderDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<TOrderDetail> detailList = orderDetailMapper.selectByExample(example);
        if (detailList != null && detailList.size() > 0) {
            for (TOrderDetail orderDetail : detailList) {
                //获取skuid
                Long skuId = orderDetail.getSkuId();
                //获取购买数量
                Integer amount = orderDetail.getAmount();
                TSku sku = skuMapper.selectByPrimaryKey(skuId);
                sku.setAvailableStock(sku.getAvailableStock() + amount);
                sku.setFrozenStock(sku.getFrozenStock() - amount);
                skuMapper.updateByPrimaryKeySelective(sku);
            }
        }
    }
}
