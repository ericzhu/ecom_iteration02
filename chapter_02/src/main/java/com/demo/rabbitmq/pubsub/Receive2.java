package com.demo.rabbitmq.pubsub;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class Receive2 {

	public static final String QUEUE2_NAME = "TEST_Q_2";

	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtil.instance().getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE2_NAME, false, false, false, null);
		channel.queueBind(QUEUE2_NAME, Send.EXCHANGE_NAME, "");

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE2_NAME, false, consumer);

		while (true) {
			Delivery delivery = consumer.nextDelivery();
			System.out.println("Receive2: " + new String(delivery.getBody()));
			Thread.sleep(1000);
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}
}
