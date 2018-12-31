package com.nemeros.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public Integer add(Integer x, Integer y) {
		return Math.addExact(x, y);
	}
}
