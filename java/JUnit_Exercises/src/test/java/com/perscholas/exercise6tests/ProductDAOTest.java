package com.perscholas.exercise6tests;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.exercise6.Product;
import com.perscholas.exercise6.ProductDAO;

@RunWith(Parameterized.class)
public class ProductDAOTest {
	private static ProductDAO pdao;
	private int productId;
	private String name;
	private double price;
	
	public ProductDAOTest(String n, double p) {
		name = n;
		price = p;
	}
	
	@BeforeClass
	public static void setup() {
		pdao = new ProductDAO();
	}
	
	@Parameters()
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] {
					{"Root Beer", 2.0},
					{"Ginger Beer", 2.5},
					{"Sprite", 1.49}
				});
	}
	
	@Test
	public void productDAOTest() throws ClassNotFoundException, SQLException, IOException {
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		assertNotNull(pdao.registerProduct(p));
	}
}
