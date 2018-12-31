package com.nemeros.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="t_book")
@Data
@EqualsAndHashCode(exclude= {"id"})
@ToString(exclude="author")
public class BookEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Integer isbn;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private AuthorEntity author;
}
