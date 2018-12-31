package com.nemeros.endpoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.IsNull;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nemeros.AbstractTI;
import com.nemeros.endpoint.pojo.Author;

public class AuthorEndpointTest extends AbstractTI {

	@Test
	public void getAllAuthor_shouldreturn_ok() throws Exception {
		mvc.perform(
				get("/author")
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$[0].id", IsNull.notNullValue()));
	}
	
	
	@Test
	public void creatingAuthor_shouldreturn_ok() throws Exception {
		Author auth = Author.builder().name("Stephen Kings").build();
		
		
		
		mvc.perform(post("/author")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(auth))
				)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(content().string(StringContains.containsString("Stephen Kings")));

	}
	
	@Test
	public void creatingAuthor_emptyName_shouldReturn_ko() throws JsonProcessingException, Exception {
		Author auth = Author.builder().name("").build();
		
		mvc.perform(post("/author")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(auth))
				)
			.andDo(print())
			.andExpect(status().is4xxClientError())
			//.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			//.andExpect(content().string(StringContains.containsString("Stephen Kings")))
			;
	}
}
