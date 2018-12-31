package com.nemeros.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nemeros.utils.pojo.Point;

@ExtendWith(SpringExtension.class)
public class UtilsTest {

	@TestConfiguration
	static class UtilsTestConf {
		
		@Bean
		public Utils utils() {
			return new Utils();
		}
	}
	
	@Autowired
	public Utils utils;
	
	
	@Test
	@DisplayName("test sum static")
	public void test_add() {
		final Integer expected = 5;
		
		assertThat(utils.add(new Integer(2), new Integer(3)))
			.describedAs("Basic Test of sum")
			.isEqualTo(expected);

	}
	
	@TestFactory
	@DisplayName("test sum dynamic")
	Stream<DynamicTest> multivalue_sum_test(){
		final List<Point> input = Arrays.asList(new Point(2, 3), new Point(4, 6), new Point(4,9));
		final List<Integer> result = Arrays.asList(5, 10, 13);

		
		return input.stream()
			.map(p -> {
				final int ix = input.indexOf(p);
				
				return DynamicTest.dynamicTest("Test sum of : " + p.toString(), 
						() -> assertThat(utils.add(p.getX(), p.getY()))
								.isEqualTo(result.get(ix))						
						);
			});
	}
}
