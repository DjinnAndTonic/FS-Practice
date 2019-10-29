package com.perscholas.test.sba02;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JUnitSBA02 {
	private static String[] testArr = {"Hello", "World"};
	private static String testStr = "Hello World";
	
	@Test
	public void testSplit() {
		assertArrayEquals(testArr, testStr.split(" "));
	}
	
	@Test
	public void testJoin() {
		assertEquals(testStr, String.join(" ", testArr));
	}
}
