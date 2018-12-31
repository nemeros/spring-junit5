package com.nemeros.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemeros.endpoint.pojo.Book;
import com.nemeros.jpa.repo.BookRepo;
import com.nemeros.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> getAllBooks() {
		
		final List<Book> bookList = new ArrayList<>();
		bookRepo.findAll().forEach(c -> bookList.add(Book.from(c)));
		
		return bookList;
	}

}
