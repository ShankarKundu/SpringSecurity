package com.example.Springsecurity.domain.infrastucture;

import com.example.Springsecurity.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositary extends JpaRepository<Book,String> {
}
