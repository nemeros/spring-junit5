package com.nemeros.endpoint;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.nemeros.endpoint.pojo.Book;
import com.nemeros.service.BookService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers=BookEndpoint.class)
public class BookEndpointTest {

	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private BookService bookService;
	
	@BeforeEach
	public void init() {
		assertThat(bookService).isNotNull().describedAs("bookService is not null");
		
		
		Mockito.when(bookService.getAllBooks())
		.thenReturn(Arrays.asList(Book.builder().name("Jurassik parc").build()));
	}
	
	@Test
	public void testBookAll() throws Exception  {
				
		mvc.perform(get("/book"))
			.andExpect(status().isOk())
			.andExpect(
					content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].name", is("Jurassik parc")));
	}
}
