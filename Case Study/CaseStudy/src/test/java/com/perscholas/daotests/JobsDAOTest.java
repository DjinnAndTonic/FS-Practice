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

import com.perscholas.daos.JobsDAO;
import com.perscholas.models.Job;

public class JobsDAOTest {
	private static JobsDAO jdao;
	
	@BeforeClass
	public static void setup() throws ClassNotFoundException, IOException, SQLException {
		System.out.println("Setting up");
		jdao = new JobsDAO();
		jdao.createJob(new Job(999, "testCompany", "test@email.com"));
		System.out.println();
	}
	
	@AfterClass
	public static void cleanup() throws SQLException {
		System.out.println("\nCleaning up");
		jdao.deleteJob(999);
		jdao.deleteJob(998);
		
		jdao.closeResources();
	}
	
	@Test
	public void testCreate() throws SQLException {		
		assertTrue(
				jdao.createJob(new Job(998, "testCompany2", "test2@")));
		
	}
	
	@Test
	public void testRead() throws ClassNotFoundException, IOException, SQLException {
		assertThat(jdao.readJobs(), is(notNullValue()));
	}
	
	@Test
	public void testUpdate() throws SQLException {
		assertTrue(jdao.updateJob(
				new Job(999, "Updated Test Company", "test@email.com")));
	}
	
	@Test
	public void testDelete() throws SQLException {
		jdao.createJob(new Job(997, "test delete company", "test-delete@email.com"));
		
		assertTrue(jdao.deleteJob(997));
	}

}
