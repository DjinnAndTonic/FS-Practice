package com.perscholas.exercisetests;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(TestEnv.class)
public class ShoppingCartTests {
//	addProductTest(), removeProductTest(), checkTimeOutTest()
	
	@Test
	public void addProductTest() {
		System.out.println("Add product");
	}
	
	@Test
	public void removeProductTest() {
		System.out.println("Remove product");
	}
	
	@Category(ProductionEnv.class)
	@Test
	public void checkTimeOutTest() {
		System.out.println("Check timeout");
	}

}
