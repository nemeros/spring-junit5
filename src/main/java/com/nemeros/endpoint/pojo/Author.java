package com.nemeros.endpoint.pojo;

import javax.validation.constraints.NotEmpty;

import com.nemeros.jpa.entity.AuthorEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

	private Integer id;
	
	@NotEmpty
	private String name;
	
	
	
	public static Author from(AuthorEntity authEnt) {
		return Author.builder()
			.id(authEnt.getId())
			.name(authEnt.getName())
			.build();
	}
}
