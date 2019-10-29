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

import com.perscholas.daos.StaffDAO;
import com.perscholas.models.Staff;

public class StaffDAOTest {
	private static StaffDAO sdao;
	
	@BeforeClass
	public static void setup() throws ClassNotFoundException, IOException, SQLException {
		System.out.println("Setting up");
		sdao = new StaffDAO();
		sdao.createStaff(new Staff("test-staff1@email.com", "John", "123-456-7890"));
		System.out.println();
	}
	
	@AfterClass
	public static void cleanup() throws SQLException {
		System.out.println("\nCleaning up");
		sdao.deleteStaff("test-staff1@email.com");
		sdao.deleteStaff("test-staff2@email.com");
		
		sdao.closeResources();
	}
	
	@Test
	public void testCreate() throws SQLException {		
		assertTrue(
				sdao.createStaff(new Staff("test-staff2@email.com", "Jill", "321-654-0897")));
		
	}
	
	@Test
	public void testRead() throws ClassNotFoundException, IOException, SQLException {
		assertThat(sdao.readStaff(), is(notNullValue()));
	}
	
	@Test
	public void testUpdate() throws SQLException {
		assertTrue(sdao.updateStaff(
				new Staff("test-staff2@email.com", "Jillean", "111-222-3333")));
	}
	
	@Test
	public void testDelete() throws SQLException {
		sdao.createStaff(new Staff("test-staff3@email.com", "Brian", "333-444-5555"));
		
		assertTrue(sdao.deleteStaff("test-staff3@email.com"));
	}

}
