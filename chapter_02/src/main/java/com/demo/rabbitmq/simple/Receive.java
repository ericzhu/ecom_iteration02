package com.demo.rabbitmq.simple;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class Receive {
	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtil.instance().getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(Send.QUEUE_NAME, false, false, false, null);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(Send.QUEUE_NAME, true, consumer);

		while (true) {
			Delivery delivery = consumer.nextDelivery();
			String msg = new String(delivery.getBody());
			System.out.println("Delivery Received - [" + msg + "]");
		}
	}
}
