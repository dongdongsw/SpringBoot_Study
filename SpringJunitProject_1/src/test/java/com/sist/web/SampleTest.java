package com.sist.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * JUnit 5
 * Spring Test 
 * AssertJ
 * 
 * assertEquals  같은 값
 * assertTrue true
 * assertNotNull null 아닌지
 * 
 */

public class SampleTest {

	@Test
	void testSum() {
		int result = 30;
		assertEquals(30,result);
	}
}
