package com.demo.rabbitmq.topic;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class ReceiveEurope {
   public static final String    TOPIC_QUEUE_1 = "test_topic_q_1";
   public static final String TOPIC_NAME_KEY = "EUROPE.*";
   
   public static void main(String[] args) throws Exception {
      Connection connection = ConnectionUtil.instance().getConnection();
      Channel channel = connection.createChannel();
      channel.queueDeclare(TOPIC_QUEUE_1, false, false, false, null);
      
      channel.queueBind(TOPIC_QUEUE_1, Send.EXCHANGE_NAME, TOPIC_NAME_KEY);
      
      QueueingConsumer consumer = new QueueingConsumer(channel);
      channel.basicConsume(TOPIC_QUEUE_1, false, consumer);
      
      // TODO to finish this class
      
   }
}
