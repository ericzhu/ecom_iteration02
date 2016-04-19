package com.demo.rabbitmq.topic;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
   public static final String EXCHANGE_NAME       = "TEST_EXCHANGE_TOPIC";
   public static final String EXCHANGE_TYPE_TOPIC = "topic";

   public static void main(String[] args) throws Exception {
      Connection connection = ConnectionUtil.instance().getConnection();
      Channel channel = connection.createChannel();
      channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE_TOPIC);

      channel.basicPublish(EXCHANGE_NAME, "USA.NEWS", null, "Test USA news".getBytes());
      channel.basicPublish(EXCHANGE_NAME, "EUROPE.NEWS", null, "Test Europe news".getBytes());
      channel.basicPublish(EXCHANGE_NAME, "USA.WEATHER", null, "Test USA weather".getBytes());
      channel.close();
      connection.close();
   }
}
