package com.demo.rabbitmq.simple;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

	public final static String QUEUE_NAME = "TEST_Q";

	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtil.instance().getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello RabbitMQ";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

		System.out.println("Message published");
		channel.close();
		connection.close();
	}
}
