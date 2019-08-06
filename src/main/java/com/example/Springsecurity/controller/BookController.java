package com.example.Springsecurity.controller;

import com.example.Springsecurity.domain.Book;
import com.example.Springsecurity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/books")
	ResponseEntity getAllBooks(){
		return ResponseEntity.ok().body(bookService.getAllBooks());
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/book")
	ResponseEntity insert(@RequestBody Book book){
		return ResponseEntity.ok().body(bookService.insertBook(book));
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/book")
	ResponseEntity update(@RequestBody Book book){
		return ResponseEntity.ok().body(bookService.updateBook(book));
	}
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/book/{id}")
	ResponseEntity getBookById(@PathVariable String id){
		return ResponseEntity.ok().body(bookService.getBookById(id));
	}
}
