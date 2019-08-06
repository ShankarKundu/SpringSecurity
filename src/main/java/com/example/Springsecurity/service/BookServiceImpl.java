package com.example.Springsecurity.service;

import com.example.Springsecurity.domain.Book;
import com.example.Springsecurity.domain.infrastucture.BookRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepositary bookRepositary;

	@Override
	public List<Book> getAllBooks() {
		return bookRepositary.findAll();
	}

	@Override
	public Book insertBook(Book book) {
		return bookRepositary.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepositary.save(book);
	}

	@Override
	public Book getBookById(String id) {
		return bookRepositary.findById(id).orElseThrow(()->new RuntimeException("Book Not Found"));
	}
}
