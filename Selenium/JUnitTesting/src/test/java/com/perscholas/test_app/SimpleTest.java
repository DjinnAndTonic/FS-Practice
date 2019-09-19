package com.perscholas.test_app;
import com.perscholas.intro_app.*;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleTest {
	@Test
	public void returnTrueTest() {
		SimpleClass sc = new SimpleClass();
		assertTrue(sc.returnTrue());
	}
}
