package com.perscholas.exercisetests;
import com.perscholas.exercises.ExerciseTwo;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExerciseTwoTest {
	private static ExerciseTwo e2;
	
	@BeforeClass
	public static void setup() {
		e2 = new ExerciseTwo(6,2);
	}
	
	@Test
	public void testOne() {
		// x + y * x;
		double result = e2.methodOne();
		
		assertThat(e2.getX() + e2.getY() * e2.getX(), closeTo(result, 0));
		assertThat(e2.getX() + e2.getY() * e2.getX(), is(result));
	}
	
	@Test
	public void testTwo() {
		// x * x - y;
		double result = e2.methodTwo();
		
		assertThat(e2.getX() * e2.getX() - e2.getY(), anyOf(is(result), closeTo(result, 0)));
		assertThat(e2.getX() * e2.getX() - e2.getY(), allOf(is(result), closeTo(result, 0)));
	}
	
	@Test
	public void testThree() {
		// x * y - x;
		double result = e2.methodThree();
		
		assertThat(e2.getX() * e2.getY() - e2.getX(), 
				allOf(greaterThan(result-0.01), lessThan(result+0.01)));
		assertThat(e2.getX() * e2.getY() - e2.getX(), is(result));
	}
	
	@Test
	public void testFour() {
		// x + y / y;
		double result = e2.methodFour();
		
		assertThat(e2.getX() + e2.getY() / e2.getY(), is(result));
	}
	
	@Test
	public void testFive() {
		// x * x * x;
		double result = e2.methodFive();
		
		assertThat(e2.getX() * e2.getX() * e2.getX(), is(result));
	}
	
	@Test
	public void testList() {
		double[] expectedList = {e2.methodOne(), e2.methodTwo(), e2.methodThree(),
				e2.methodFour(), e2.methodFive()};
		
		assertThat(e2.getList().get(0), is(e2.methodOne()));
		assertThat(e2.getList().get(0), not(e2.methodOne()-2));
	}
}
