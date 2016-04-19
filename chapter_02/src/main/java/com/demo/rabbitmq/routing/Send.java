package com.demo.rabbitmq.routing;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

   public static final String EXCHANGE_NAME        = "TEST_EXCHANGE_DIRECT";
   public static final String EXCHANGE_TYPE_DIRECT = "direct";

   public static void main(String[] args) throws Exception {
      Connection connection = ConnectionUtil.instance().getConnection();
      Channel channel = connection.createChannel();

      channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE_DIRECT);

      channel.basicPublish(EXCHANGE_NAME, "dog", null, "Hello Doggy!".getBytes());
      channel.basicPublish(EXCHANGE_NAME, "cat", null, "Hello Kitty!".getBytes());

      channel.close();
      connection.close();
   }
}
