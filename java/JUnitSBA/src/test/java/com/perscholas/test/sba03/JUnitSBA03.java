package com.perscholas.test.sba03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JUnitSBA03 {
	private int testInt = 7;
	
	@Test
	public void testToBinString() {
		assertEquals("111", Integer.toBinaryString(testInt));
	}
}
