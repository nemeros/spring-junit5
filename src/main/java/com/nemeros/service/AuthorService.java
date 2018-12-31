package com.nemeros.service;

import java.util.List;

import com.nemeros.endpoint.pojo.Author;

public interface AuthorService {

	List<Author> getAllAuthor();
	
	Author create(Author auth);

}