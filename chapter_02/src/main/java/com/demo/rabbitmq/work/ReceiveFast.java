package com.demo.rabbitmq.work;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class ReceiveFast {

	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtil.instance().getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(Send.QUEUE_NAME, false, false, false, null);
		channel.basicQos(1); 
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		
		// autoAck = false -> don't acknowledge automatically the message consumption.
		channel.basicConsume(Send.QUEUE_NAME, false, consumer);
		
		while (true) {
			Delivery delivery = consumer.nextDelivery();
			System.out.println(new String(delivery.getBody()));
			Thread.sleep(1000);
			
			// Acknowledge the message broker of the message consumption.
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}
}
