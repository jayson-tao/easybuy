package com.yaorange.service.impl;

import javax.jms.Connection;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.stereotype.Service;

import com.yaorange.listener.SecKillListener;
import com.yaorange.utils.MQBinding;

/**
 * 将单品队列和消费者绑定
 */
@Service
public class ActiveMQService {
	@Autowired
	private SingleConnectionFactory connectionFactory;
	@Autowired
	private SecKillListener secKillListener;

	/**
	 * 创建消息队列
	 * @param queueName
	 * @return
	 */
	public MQBinding createMQBinding(String queueName) {
		MQBinding mqBinding = null;
		try {
			Connection connection = connectionFactory.createConnection();
			mqBinding =new MQBinding(queueName, connection, secKillListener);
		} catch (JMSException e) {
			e.printStackTrace();
		}

		return mqBinding;
	}

	/**
	 * 取消绑定消息队列
	 * @param queueName
	 */
	public void releaseBinding(String queueName) {
		try {
			Connection connection = connectionFactory.createConnection();
			ActiveMQDestination destination = ActiveMQDestination.createDestination(queueName, ActiveMQDestination.QUEUE_TYPE);
			if (connection instanceof ActiveMQConnection) {
				ActiveMQConnection sonConnection = (ActiveMQConnection) connection;
				sonConnection.destroyDestination(destination);
			}
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
