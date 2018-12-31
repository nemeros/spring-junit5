package com.nemeros.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nemeros.jpa.entity.BookEntity;
import com.nemeros.jpa.repo.BookRepo;
import com.nemeros.service.impl.BookServiceImpl;

@ExtendWith(SpringExtension.class)
public class BookServiceTest {

	@TestConfiguration
	static class BookServiceTestConf {
		
		@Bean
		public BookService bookService() {
			return new BookServiceImpl();
		}
	}
	
	@Autowired
	private BookService bookService;
	
	@MockBean
	private BookRepo bookRepo;
	
	
	@Test
	public void getAllBooks_test() {
		BookEntity book = new BookEntity();
		Mockito.when(bookRepo.findAll()).thenReturn(Stream.of(book).collect(Collectors.toList()));
		
		assertThat(bookService.getAllBooks()).hasSize(1);
	}
}
