package com.springdata;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdata.domain.Book;
import com.springdata.repository.BookRepository;

public class Application_Find {

   @SuppressWarnings("serial")
   public static void main(String[] args) {
      try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class)) {
         BookRepository bookRepository = context.getBean(BookRepository.class);
         printBooks(bookRepository.findOne(1L));
         printBooks(bookRepository.findAll());
         printBooks(bookRepository.findAll(new ArrayList<Long>() {
            {
               add(1L);
               add(3L);
            }
         }));
      }
   }

   @SuppressWarnings("unchecked")
   public static void printBooks(Object books) {
      System.out.println("***********************");
      if (Collection.class.isAssignableFrom(books.getClass())) {
         for (Book book : (Collection<Book>)books) {
            System.out.println(book);
         }
      }
      else {
         System.out.println(books);
      }
   }
}
