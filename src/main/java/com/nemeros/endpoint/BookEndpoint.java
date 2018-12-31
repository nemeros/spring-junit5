package com.nemeros.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nemeros.endpoint.pojo.Book;
import com.nemeros.service.BookService;

@RestController
@RequestMapping(path="book")
public class BookEndpoint {

	@Autowired
	private BookService bookservice;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {

		return new ResponseEntity<>(bookservice.getAllBooks(), HttpStatus.OK);
	}
}
