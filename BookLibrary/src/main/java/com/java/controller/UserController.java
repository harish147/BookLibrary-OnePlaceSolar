package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.Book;
import com.java.entity.User;
import com.java.service.BookService;
import com.java.service.UserService;

@Controller
public class UserController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public User registerUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("loginId") String loginId, @RequestParam("password") String password

	) {
		User user = new User();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLoginId(loginId);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setRole("ROLE_USER");
		return userService.saveUser(user);
	}

	@GetMapping("/home")
	public String home(Model model) {
		String loginId = SecurityContextHolder.getContext().getAuthentication().getName();

		model.addAttribute("allBooks", bookService.getAllBooks());
		model.addAttribute("userFavoriteBooks", userService.getUserByLoginId(loginId).getFavouriteBooks());

		return "home";
	}

	@PostMapping("/favorite")
	public String addFavorite(@RequestBody List<Integer> favoriteSelection) {
		
		
		List<Book> booksToAdd = bookService.getBooksById(favoriteSelection);

		String loginId = SecurityContextHolder.getContext().getAuthentication().getName();


		User user = userService.getUserByLoginId(loginId);

		user.getFavouriteBooks().addAll(booksToAdd);
		
		userService.saveUser(user);
		
		return "home"; 
	}

	@DeleteMapping("/favorite")
	public String deleteFavorite(@RequestBody List<Integer> bookIdsToRemoveFavorite) {
		String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
				
		List<Book> booksToDelete = bookService.getBooksById(bookIdsToRemoveFavorite);

		User user = userService.getUserByLoginId(loginId);

		user.getFavouriteBooks().removeAll(booksToDelete);

		userService.saveUser(user);
		return "home";
	}

}
