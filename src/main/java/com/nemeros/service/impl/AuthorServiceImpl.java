package com.nemeros.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nemeros.endpoint.pojo.Author;
import com.nemeros.jpa.entity.AuthorEntity;
import com.nemeros.jpa.repo.AuthorRepo;
import com.nemeros.service.AuthorService;

@Service
@Transactional(rollbackFor=Exception.class)
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepo authorRepo;
	
	@Override
	public List<Author> getAllAuthor() {
		final List<Author> authorList = new ArrayList<>();
		authorRepo.findAll().forEach(c -> {
			authorList.add(Author.from(c));
		});
		
		
		return authorList;
	}

	@Override
	public Author create(Author auth) {
		AuthorEntity ent = new AuthorEntity();
		ent.setName(auth.getName());
		
		return Author.from(authorRepo.save(ent));
	}

}
 