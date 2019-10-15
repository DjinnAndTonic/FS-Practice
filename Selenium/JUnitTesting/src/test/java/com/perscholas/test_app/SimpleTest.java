package com.perscholas.test_app;
import com.perscholas.intro_app.*;

import static org.junit.Assert.assertTrue;

import org.hamcrest.collection.IsIterableContainingInOrder;
import java.time.LocalTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleTest {
	
	private static SimpleClass sc;
	
	@BeforeClass
	public static void createSimpleClass() {
		sc = new SimpleClass();
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up test method @ " + LocalTime.now());
	}
	@After
	public void tearDown() {
		System.out.println("Tearing down test method @ "  + LocalTime.now() + "\n");
	}
	
	@Test
	public void returnTrueTest() {
//		SimpleClass sc = new SimpleClass();
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	    System.out.println(methodName);
		assertTrue(sc.returnTrue());
	}
	
	@Test
	public void returnFalseTest() {
//		SimpleClass sc = new SimpleClass();
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	    System.out.println(methodName);
		assertFalse(sc.returnFalse());
	}
	
	@Test
	public void returnNullTest() {
//		SimpleClass sc = new SimpleClass();
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	    System.out.println(methodName);
		assertNull(sc.returnNull());
	}
	
	@Test
	public void returnListContentTest() {
//		SimpleClass sc = new SimpleClass();
		String[] expectedList = {"red", "green", "blue"};
//		String[] expectedList = {"green", "red", "blue"};
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	    System.out.println(methodName);
		
		assertThat(sc.returnList(), 
			       IsIterableContainingInOrder.contains(expectedList));
	}
	
	@Test
	public void returnTrueHamcrest() {
//		SimpleClass sc = new SimpleClass();
		
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	    System.out.println(methodName);
		
		assertThat(sc.returnTrue(), is(true));
	}
}
