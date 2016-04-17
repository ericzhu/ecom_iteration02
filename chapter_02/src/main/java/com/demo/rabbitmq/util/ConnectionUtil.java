package com.demo.rabbitmq.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

	private static ConnectionUtil instance;

	private ConnectionFactory connectionFactory;

	private ConnectionUtil() {

	}

	public static ConnectionUtil instance() throws Exception {
		if (instance == null) {
			instance = new ConnectionUtil();
			instance.connectionFactory = new ConnectionFactory();
			instance.connectionFactory.setHost("localhost");
			instance.connectionFactory.setPort(5672);
			instance.connectionFactory.setVirtualHost("/taotao");
			instance.connectionFactory.setUsername("taotao");
			instance.connectionFactory.setPassword("taotao");

		}
		return instance;
	}

	public Connection getConnection() throws IOException, TimeoutException {
		return this.connectionFactory.newConnection();
	}
}
