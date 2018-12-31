package com.nemeros.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nemeros.endpoint.pojo.Author;
import com.nemeros.service.AuthorService;

@RestController(value="author")
@RequestMapping(path="author", consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
public class AuthorEndpoint {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Author>> getAllAuthor() {

		return new ResponseEntity<>(authorService.getAllAuthor(),HttpStatus.OK);
	}
	
	@PostMapping
	public Author createAuthor(@RequestBody @Valid Author auth) {
		
		
		return authorService.create(auth);
	}
	
}
