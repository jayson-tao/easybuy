package com.yaorange.consumer;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.yaorange.consts.bis.OrderStateConsts;
import com.yaorange.mapper.TOrderMapper;
import com.yaorange.pojo.TOrder;

/**
 * 确认取消订单消费者
 */
public class CancelOrderConfirmListener implements MessageListener {
	@Autowired
	private TOrderMapper orderMapper;

	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;
		try {
			long orderId = mapMessage.getLong("orderId");
			boolean success = mapMessage.getBoolean("success");
			if(success){
				changeOrderStatus(orderId);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改订单状态
	 * @param orderId
	 */
	private void changeOrderStatus(long orderId) {
		TOrder order = orderMapper.selectByPrimaryKey(orderId);
		order.setState(OrderStateConsts.CLOSED);
		orderMapper.updateByPrimaryKeySelective(order);
	}

}
