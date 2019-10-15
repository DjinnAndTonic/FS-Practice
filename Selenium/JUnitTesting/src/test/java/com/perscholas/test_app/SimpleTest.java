package com.perscholas.test_app;
import com.perscholas.intro_app.*;

import static org.junit.Assert.assertTrue;

import org.hamcrest.collection.IsIterableContainingInOrder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SimpleTest {
	@Test
	public void returnTrueTest() {
		SimpleClass sc = new SimpleClass();
		assertTrue(sc.returnTrue());
	}
	
	@Test
	public void returnFalseTest() {
		SimpleClass sc = new SimpleClass();
		assertFalse(sc.returnFalse());
	}
	
	@Test
	public void returnNullTest() {
		SimpleClass sc = new SimpleClass();
		assertNull(sc.returnNull());
	}
	
	@Test
	public void returnListContentTest() {
		SimpleClass sc = new SimpleClass();
		String[] expectedList = {"red", "green", "blue"};
//		String[] expectedList = {"green", "red", "blue"};
		assertThat(sc.returnList(), 
			       IsIterableContainingInOrder.contains(expectedList));
	}
	
	@Test
	public void returnTrueHamcrest() {
		SimpleClass sc = new SimpleClass();
		assertThat(sc.returnTrue(), is(true));
	}
}
