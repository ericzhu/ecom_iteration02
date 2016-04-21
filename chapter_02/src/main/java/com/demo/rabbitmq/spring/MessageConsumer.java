package com.demo.rabbitmq.spring;

public class MessageConsumer {

   public void consume(String message) {
      System.out.println("Message Received: " + message);
   }

}
