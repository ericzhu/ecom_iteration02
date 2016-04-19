package com.demo.rabbitmq.pubsub;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

	public static final String EXCHANGE_NAME = "TEST_EXCHANGE_FANOUT";

	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtil.instance().getConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout", false);

		String message = "Hello Exchange!";
		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());

		channel.close();
		connection.close();
	}
}
