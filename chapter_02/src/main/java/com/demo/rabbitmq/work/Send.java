package com.demo.rabbitmq.work;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

	public static final String QUEUE_NAME = "TEST_WORK_Q";

	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtil.instance().getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		for (int i = 0; i < 10; i++) {
			String message = "Message [" + i + "]";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			Thread.sleep(10);
		}
		channel.close();
		connection.close();
	}
}
