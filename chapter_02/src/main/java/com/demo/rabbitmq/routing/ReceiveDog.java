package com.demo.rabbitmq.routing;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class ReceiveDog {
   public static final String QUEQUE_DOG = "TEST_Q_DOG";

   public static void main(String[] args) throws Exception {
      Connection connection = ConnectionUtil.instance().getConnection();
      Channel channel = connection.createChannel();

      channel.queueDeclare(QUEQUE_DOG, false, false, false, null);
      channel.queueBind(QUEQUE_DOG, Send.EXCHANGE_NAME, "dog");

      QueueingConsumer consumer = new QueueingConsumer(channel);
      
      channel.basicConsume(QUEQUE_DOG, false, consumer);

      while (true) {
         Delivery delivery = consumer.nextDelivery();
         System.out.println("ReceiveDog: " + new String(delivery.getBody()));
         Thread.sleep(1000);
         channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
      }
   }
}
