package com.nemeros.endpoint.pojo;

import com.nemeros.jpa.entity.BookEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

	
	private Integer id;
	private String name;
	private Integer isbn;
	
	public static Book from(BookEntity ent) {
		return Book.builder()
			.id(ent.getId())
			.name(ent.getName())
			.isbn(ent.getIsbn())
			.build();
	}
}
