package com.demo.rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/demo/rabbitmq/spring/spring-amqp.xml");
      RabbitTemplate template = context.getBean(RabbitTemplate.class);
      template.convertAndSend("Hello Spring Rabbit");
      context.close();
      context.destroy();
   }
}
