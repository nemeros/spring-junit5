package com.nemeros.jpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_author")
@Data
@EqualsAndHashCode(exclude="books")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	private Integer age;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="author")
	@JsonManagedReference
	private Set<BookEntity> books;
}
