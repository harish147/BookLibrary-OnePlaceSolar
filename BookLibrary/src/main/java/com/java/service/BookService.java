package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.entity.Book;
import com.java.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> getAllBooks(){
		
		return bookRepository.findAll();
	}
	
	
	public List<Book> getBooksById(List<Integer> bookIds) {
		return bookRepository.findAllById(bookIds);
	}
}
