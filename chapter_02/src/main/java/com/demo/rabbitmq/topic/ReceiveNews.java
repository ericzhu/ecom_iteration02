package com.demo.rabbitmq.topic;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class ReceiveNews {
   
   public static final String TOPIC_QUEUE_2  = "test_topic_q_2";
   public static final String TOPIC_NAME_KEY = "*.NEWS";
   
   public static void main(String[] args) throws Exception {
      Connection connection = ConnectionUtil.instance().getConnection();
      Channel channel = connection.createChannel();
      channel.queueDeclare(TOPIC_QUEUE_2, false, false, false, null);

      channel.queueBind(TOPIC_QUEUE_2, Send.EXCHANGE_NAME, TOPIC_NAME_KEY);

      QueueingConsumer consumer = new QueueingConsumer(channel);
      channel.basicConsume(TOPIC_QUEUE_2, false, consumer);

      while (true) {
         Delivery delivery = consumer.nextDelivery();
         System.out.println(new String(delivery.getBody()));
         channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
      }
   }
}
