package com.perscholas.exercisetests;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(TestEnv.class)
public class ProductTests {
//	createProductTest() and restockInventoryTest().
	
	@Test
	public void createProductTest() {
		System.out.println("Create product");
	}
	
	@Category(ProductionEnv.class)
	@Test
	public void restockInventoryTest() {
		System.out.println("Restock inventory");
	}
}
