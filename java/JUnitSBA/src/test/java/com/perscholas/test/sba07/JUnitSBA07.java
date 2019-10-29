package com.perscholas.test.sba07;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.main.sba07.AddVaryingTypeCalculator;

@RunWith(Parameterized.class)
public class JUnitSBA07 {
	private static AddVaryingTypeCalculator a;
	private static List<Object> nums;
	private Object first;
	private Object second;
	private static double expected;
	private Exception e;
	
	public JUnitSBA07(Object first, Object second, double expected, Exception e) {
		nums.add(0, first);
		nums.add(1, second);
		JUnitSBA07.expected = expected;
		this.e = e;
	}

	@Parameters()
	public static Collection<Object[]> data(){
		return Arrays.asList(
				new Object[][] {
					{0, 5, 5.0, null},
					{"1.2", "4.3", 5.5, null},
					{'1', '3', 4, null},
					{5.4, 5.6, 11.0, null}
				});
	}
	
	@BeforeClass
	public static void setup() {
		nums = new ArrayList<Object>();
		a = new AddVaryingTypeCalculator();
	}
	
	@After
	public void clearList() {
		nums.clear();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testErrorThrowing1() {
		nums.add('a');
		nums.add('b');
		a.addTwoNumbersVaryingType(nums);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testErrorThrowing2() {
		nums.add("hello");
		nums.add("there");
		a.addTwoNumbersVaryingType(nums);
	}
	
	@Test
	public void testCalculation() {
		assertThat(a.addTwoNumbersVaryingType(nums), is(expected));
	}
}
