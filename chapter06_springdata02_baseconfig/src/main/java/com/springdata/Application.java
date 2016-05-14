package com.springdata;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdata.domain.Book;
import com.springdata.repository.BookRepository;

public class Application {
   public static void main(String[] args) {
      try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class)) {
         BookRepository bookRepository = context.getBean(BookRepository.class);
         Book book = bookRepository.findOne(1L);
         System.out.println(book);
      }
   }
}
