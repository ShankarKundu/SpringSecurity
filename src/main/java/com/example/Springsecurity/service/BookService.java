package com.example.Springsecurity.service;


import com.example.Springsecurity.domain.Book;

import java.util.List;

public interface BookService {
	List<Book> getAllBooks();

	Book insertBook(Book book);

	Book updateBook(Book book);

	Book getBookById(String id);
}
