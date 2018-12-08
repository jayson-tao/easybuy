package com.yaorange.utils;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;


public class MQBinding {
	private Connection connection = null;
	private MessageConsumer consumer = null;
	private Session session = null;

	public MQBinding(String queueName, Connection connection, MessageListener listener) {
		try {
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(queueName);
			consumer = session.createConsumer(queue);
			consumer.setMessageListener(listener);

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void ReleaseConsumer() {
		try {
			consumer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
