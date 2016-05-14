package com.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdata.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
