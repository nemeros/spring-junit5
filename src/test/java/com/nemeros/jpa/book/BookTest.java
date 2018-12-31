package com.nemeros.jpa.book;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nemeros.jpa.entity.BookEntity;
import com.nemeros.jpa.repo.BookRepo;

@ExtendWith(SpringExtension.class)
@DataJpaTest(showSql=true)
public class BookTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BookRepo repo;
	
	@Test
	public void should_find_one_book() {
		Iterable<BookEntity> ite = repo.findAll();
		assertThat(ite).hasSize(2);
	}
	
	@Test
	public void create_new_and_check_existance() {
		BookEntity b = new BookEntity();
		b.setName("John");
		
		final BookEntity b1 = repo.save(b);
		b.setName("doh");
		
		assertThat(b1.getName()).isEqualTo(b.getName());
	}
}
