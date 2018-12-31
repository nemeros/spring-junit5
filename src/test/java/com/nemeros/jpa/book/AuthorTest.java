package com.nemeros.jpa.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nemeros.jpa.entity.AuthorEntity;
import com.nemeros.jpa.repo.AuthorRepo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AuthorTest {

	@Autowired
	private AuthorRepo repo;
	
	@TestFactory
	Stream<DynamicTest> test_repo(){
		List<AuthorEntity> inputOk = Arrays.asList(
				AuthorEntity.builder().name("Serghei").age(35).build(),
				AuthorEntity.builder().name("Andrew").age(50).build()
				);
		
		List<AuthorEntity> inputKo = Arrays.asList(
				AuthorEntity.builder().age(47).build()
				);
		
		Stream<DynamicTest> test_ok = inputOk
				.stream()
				.map(ent -> DynamicTest.dynamicTest("Test saving entity :" + ent.toString(),
						() -> {
							final AuthorEntity entSaved = repo.save(ent);
							assertThat(entSaved.getName())
								.isEqualTo(ent.getName());
						}));
		
		
		Stream<DynamicTest> test_ko = inputKo
				.stream()
				.map(ent -> DynamicTest.dynamicTest("Test saving entity with error :" + ent.toString(),
						() -> 
							assertThrows(DataIntegrityViolationException.class, () -> repo.save(ent))
						));
		
		
		return Stream.concat(test_ko, test_ok);
	}
	
}
