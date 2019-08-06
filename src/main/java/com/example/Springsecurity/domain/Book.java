package com.example.Springsecurity.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Book {
	@Id
	private String bookId= UUID.randomUUID().toString();
	private String bookName;
}
