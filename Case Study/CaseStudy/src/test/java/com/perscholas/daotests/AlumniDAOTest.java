package com.perscholas.daotests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.daos.AlumniDAO;
import com.perscholas.models.Alumnus;

public class AlumniDAOTest {
	private static AlumniDAO adao;
	
	@BeforeClass
	public static void setup() throws ClassNotFoundException, IOException, SQLException {
		System.out.println("Setting up");
		adao = new AlumniDAO();
		adao.createAlumnus(new Alumnus("mock1@email.com", "Jill", 
				"1234 Hill Ln.", "123-456-7890", "Fairytail", "LD", "12345"));
		System.out.println();
	}
	
	@AfterClass
	public static void cleanup() throws SQLException {
		System.out.println("\nCleaning up");
		adao.deleteAlumnus("testalum@email.com");
		adao.deleteAlumnus("mock1@email.com");
		
		adao.closeResources();
	}
	
	@Test
	public void testCreate() throws SQLException {		
		assertTrue(
				adao.createAlumnus(new Alumnus("testalum@email.com", "John", 
				"123 Test St.", "972-123-4567", "Dallas", "TX", "12345")));
		
	}
	
	@Test
	public void testRead() throws ClassNotFoundException, IOException, SQLException {
		assertThat(adao.readAlumnus(), is(notNullValue()));
	}
	
	@Test
	public void testUpdate() throws SQLException {
		assertTrue(adao.updateAlumnus(
				new Alumnus("mock1@email.com", "Jill",
						"123 Test St.", "123-456-7890", "Dallas", "TX", "12345")));
	}
	
	@Test
	public void testDelete() throws SQLException {
		adao.createAlumnus(new Alumnus("testalum-delete@email.com", "Jake", 
				"312 Test St.", "972-564-6234", "Plano", "TX", "54345"));
		
		assertTrue(adao.deleteAlumnus("testalum-delete@email.com"));
	}

}
