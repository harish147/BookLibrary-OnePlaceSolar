package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.Book;
import com.java.repository.BookRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public String getHomePage() {
		return "adminhome";
	}
	
	@PostMapping("/savebook")
	public String saveBook(@RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("genre") String genre, @RequestParam("summary") String summary) {
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setSummary(summary);
		
		return "adminhome";
		
	}
}
