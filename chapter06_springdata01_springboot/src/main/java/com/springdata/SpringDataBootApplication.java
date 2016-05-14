package com.springdata;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springdata.domain.Book;
import com.springdata.repository.BookRepository;

@SpringBootApplication
public class SpringDataBootApplication {
   public static void main(String[] args) {
      ApplicationContext context = SpringApplication.run(SpringDataBootApplication.class, args);
      BookRepository repository = context.getBean(BookRepository.class);
      
      Book book = new Book();
      book.setTitle("Test Book");
      repository.save(book);
   }
}
