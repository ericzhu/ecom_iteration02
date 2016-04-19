package com.demo.rabbitmq.routing;

import com.demo.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class ReceiveCat {

   public static final String QUEQUE_CAT = "TEST_Q_CAT";

   public static void main(String[] args) throws Exception {
      Connection connection = ConnectionUtil.instance().getConnection();
      Channel channel = connection.createChannel();

      channel.queueDeclare(QUEQUE_CAT, false, false, false, null);
      channel.queueBind(QUEQUE_CAT, Send.EXCHANGE_NAME, "cat");

      QueueingConsumer consumer = new QueueingConsumer(channel);

      channel.basicConsume(QUEQUE_CAT, false, consumer);

      while (true) {
         Delivery delivery = consumer.nextDelivery();
         System.out.println("ReceiveCat: " + new String(delivery.getBody()));
         Thread.sleep(1000);
         channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
      }
   }
}
