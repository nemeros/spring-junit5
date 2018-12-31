package com.nemeros.jpa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nemeros.jpa.entity.AuthorEntity;

@Repository
public interface AuthorRepo extends CrudRepository<AuthorEntity, Integer> {

}
