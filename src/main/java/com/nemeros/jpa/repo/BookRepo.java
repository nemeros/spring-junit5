package com.nemeros.jpa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nemeros.jpa.entity.BookEntity;

@Repository
public interface BookRepo extends CrudRepository<BookEntity, Integer> {

}
