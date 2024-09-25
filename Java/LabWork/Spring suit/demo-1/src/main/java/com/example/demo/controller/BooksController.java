package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Books;
import com.example.demo.service.BooksService;

@RestController
public class BooksController {

	@SuppressWarnings("unused")
	@Autowired
	BooksService bookservice;
	@GetMapping("/book")
	private List<Books> getAllBooks() {
		return bookservice.getAllBooks();
	}
	
	@GetMapping("book/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return bookservice.getBooksById(bookid);
	}

	@DeleteMapping("book/{bookid}")
	private void deletebook(@PathVariable("bookid") int bookid) {
		bookservice.delete(bookid);
	}

	@PostMapping("/books")
	private int saveBook(@RequestBody Books books) {
		bookservice.saveOrUpdate(books);
		return books.getBookid();
	}

	@PutMapping("/books")
	private Books update(@RequestBody Books books) {
		bookservice.saveOrUpdate(books);
		return books;
	}
}
