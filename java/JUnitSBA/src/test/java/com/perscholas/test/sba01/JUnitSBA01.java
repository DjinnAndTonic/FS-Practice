package com.perscholas.test.sba01;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

/* Test the following methods of the String class: length(), 
 * equalsIgnoreCase(String), contentEquals(String Builder), 
 * charAt(int), contains(String), startsWith(String), 
 * startsWith(String, int), endsWith(String), 
 * substring(int, int) and toLowerCase(). Use at least four 
 * different JUnit assert methods. Use the test string 
 * "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201".
*/

public class JUnitSBA01 {
	private static String testStr;
	
	@BeforeClass
	public static void setup() {
		testStr = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
	}
	
	@Test
	public void testLength() {
		assertSame(testStr.length(), 53);
	}
	
	@Test 
	public void testIgnoreCase() {
		String uppercase = testStr.toUpperCase();
		String lowercase = testStr.toLowerCase();
		
		assertTrue(testStr.equalsIgnoreCase(uppercase));
		assertTrue(testStr.equalsIgnoreCase(lowercase));
	}
	
	@Test
	public void testContentEquals() {
		StringBuffer sb = new StringBuffer(testStr);
		
		assertThat(testStr.contentEquals(sb), is(true));
	}
	
	@Test
	public void testCharAt() {
		assertEquals(testStr.charAt(0), 'P');
	}
	
	@Test
	public void testContains() {
		String partial = "211 N Ervay St.";
		
		assertTrue(testStr.contains(partial));
	}
	
	@Test
	public void testStartsWith() {
		String start = "Per Scholas";
		
		assertTrue(testStr.startsWith(start));
	}
	
	@Test
	public void testEndsWith() {
		String end = "75201";
		
		assertTrue(testStr.endsWith(end));
	}
	
	@Test
	public void testSubstring() {
		String partial = "Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
		
		assertEquals(testStr.substring(4, 53), partial);
	}
	
	@Test
	public void testLowerCase() {
		String lowercase = "per scholas - 211 n ervay st. #700 - dallas, tx 75201";
		
		assertEquals(testStr.toLowerCase(), lowercase);
	}
}
