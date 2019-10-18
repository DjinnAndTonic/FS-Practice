package com.perscholas.exercisetests;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.exceptions.*;
import com.perscholas.exercises.Product;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ExerciseFiveTest {
	
	private static Product product;
	private int productId;
	private String name;
	private String description;
	private double price;
	
	public ExerciseFiveTest(int id, String n, String d, double p) {
		productId = id;
		name = n;
		description = d;
		price = p;
	}
	
	@Parameters()
	public static Collection<Object[]> data(){
		return Arrays.asList(
				new Object[][] 	{
					{1, "Snickers", "Chocolate covered nougat with caramels and peanuts", 1.79},
					{2, "Twix", "Right Twix", 1.89},
					{3, "Reese's Cups", "Peanut butter and Chocolate", 2.50}
				});
	}
	
	@BeforeClass
	public static void setup() {
		product = new Product();
	}
	
	@Test(expected = InsufficientQuantityException.class)
	public void testInsufficientQuantity() throws InsufficientQuantityException {
		product.reduceAvailableQuantity(1000000);
	}
	
	@Test(expected = MaximumQuantityExceededException.class)
	public void testMaximumQuantiyt() throws MaximumQuantityExceededException{
		product.setAvailableQuantity(1000000);
	}
	
	@Test
	public void  testOne() throws InsufficientQuantityException{
		assertThat(product.getAvailableQuantity(), greaterThan(0));
	}
	
	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	@Test
	public void throwInsufficientQuantityException() throws InsufficientQuantityException {
		ee.expect(InsufficientQuantityException.class);
		
		throw new InsufficientQuantityException();
	}
	
	@Test
	public void throwMaximumQuantityExceededException() throws MaximumQuantityExceededException{
		ee.expect(MaximumQuantityExceededException.class);
		
		throw new MaximumQuantityExceededException();
	}
}
