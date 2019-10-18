package com.perscholas.exercisetests;
import com.perscholas.exercises.ExerciseOne;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExerciseOneTest {
	private static ExerciseOne e1;
	
	@BeforeClass
	public static void setup() {
		e1 = new ExerciseOne(6,2);
	}
	
	@Test
	public void testAdd() {
		assertSame(8, e1.add());
	}
	
	@Test
	public void testSub() {
		assertEquals(4, e1.subtract());
	}
	
	@Test
	public void testMult() {
		assertTrue(12 == e1.multiply());
	}
	
	@Test
	public void testDiv() {
		assertThat(3.0, is(e1.divide()));
	}

}
