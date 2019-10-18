package com.perscholas.exercisetests;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(TestEnv.class)
public class PaymentTests {
//	verifyPaymentTest(), submitPaymentTest() and confirmPaymentTest().
	@Category(ProductionEnv.class)
	@Test
	public void verifyPaymentTest() {
		System.out.println("Verify payment");
	}
	
	@Test
	public void submitPaymentTest() {
		System.out.println("Submit payment");
	}
	
	@Test
	public void confirmPaymentTest() {
		System.out.println("Confirm payment");		
	}
}
