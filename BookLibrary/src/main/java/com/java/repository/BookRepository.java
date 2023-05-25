package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
}
