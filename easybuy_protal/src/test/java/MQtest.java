import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class MQtest {

    /**
     * 生产者
     */
    @Test
    public void testQueueProducer() throws Exception {
        // 1、创建一个连接工厂对象，需要指定服务的ip及端口。
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.23.130:61616");
        // 2、使用工厂对象创建一个Connection对象。
        Connection connection = factory.createConnection();
        // 3、开启连接，调用Connection对象的start方法。
        connection.start();
        // 4、创建一个Session对象。
        // 第一个参数：是否开启事务。如果true开启事务，第二个参数无意义。一般不开启事务false。
        // 第二个参数：应答模式。自动应答或者手动应答。一般自动应答。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用queue
        Queue queue = session.createQueue("test queue");
        // 6、使用Session对象创建一个Producer对象。
        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage("柳岩 来呀 互相伤害呀");
        producer.send(message);
        producer.close();
        session.close();
        connection.close();
        System.out.println("生产已完成");
    }

    /**
     * 消费者
     */
    @Test
    public void testQueueConsumer() throws Exception {
        // 1、创建一个连接工厂对象，需要指定服务的ip及端口。
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.23.130:61616");
        // 2、使用工厂对象创建一个Connection对象。
        Connection connection = factory.createConnection();
        // 3、开启连接，调用Connection对象的start方法。
        connection.start();
        // 4、创建一个Session对象。
        // 第一个参数：是否开启事务。如果true开启事务，第二个参数无意义。一般不开启事务false。
        // 第二个参数：应答模式。自动应答或者手动应答。一般自动应答。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用queue
        Queue queue = session.createQueue("test queue");

        MessageConsumer consumer = session.createConsumer(queue);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println("消费者2消费的消息为" + text);
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread.sleep(100);
        System.out.println("消费者已启动消费");
        System.in.read();
        Thread.sleep(100);
        session.close();
        connection.close();
    }

    @Test
    public void testTopicProducer() throws Exception {
        // 1、创建一个连接工厂对象，需要指定服务的ip及端口。
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.23.130:61616");
        // 2、使用工厂对象创建一个Connection对象。
        Connection connection = factory.createConnection();
        // 3、开启连接，调用Connection对象的start方法。
        connection.start();
        // 4、创建一个Session对象。
        // 第一个参数：是否开启事务。如果true开启事务，第二个参数无意义。一般不开启事务false。
        // 第二个参数：应答模式。自动应答或者手动应答。一般自动应答。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用queue
        Topic topic = session.createTopic("qiangge_topic");
        MessageProducer producer = session.createProducer(topic);
        TextMessage text = session.createTextMessage("凤姐了解一下");
        producer.send(text);
        System.out.println("生产已完成");
        // 9、关闭资源
        producer.close();
        session.close();
        connection.close();
    }


    @Test
    public void testTopicConsumer() throws Exception {
        // 1、创建一个连接工厂对象，需要指定服务的ip及端口。
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.23.130:61616");
        // 2、使用工厂对象创建一个Connection对象。
        Connection connection = factory.createConnection();
        // 3、开启连接，调用Connection对象的start方法。
        connection.start();
        // 4、创建一个Session对象。
        // 第一个参数：是否开启事务。如果true开启事务，第二个参数无意义。一般不开启事务false。
        // 第二个参数：应答模式。自动应答或者手动应答。一般自动应答。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用queue
        Topic topic = session.createTopic("qiangge_topic");

        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println("学生3" + text);
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread.sleep(100);
        System.out.println("学生启动消费");
        System.in.read();
        Thread.sleep(100);
        session.close();
        connection.close();
    }
}
