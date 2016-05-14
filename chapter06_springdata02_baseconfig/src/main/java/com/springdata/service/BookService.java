package com.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.domain.Book;
import com.springdata.repository.BookRepository;

@Service
public class BookService {
   
   @Autowired
   private BookRepository bookRepository;
   
   public void save(Book book) {
      bookRepository.save(book);
   }
}
