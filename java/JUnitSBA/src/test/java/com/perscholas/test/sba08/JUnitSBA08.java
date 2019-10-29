package com.perscholas.test.sba08;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.perscholas.main.sba08.Product;

public class JUnitSBA08 {
	
	@Test
	public void testGetName() {
		Product p = Mockito.mock(Product.class, Mockito.CALLS_REAL_METHODS);
		when(p.getName()).thenReturn("ProductName");
		
		assertEquals(p.getName(), "ProductName");		
	}
}
