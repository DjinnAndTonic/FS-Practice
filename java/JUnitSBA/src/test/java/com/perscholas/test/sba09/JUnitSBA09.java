package com.perscholas.test.sba09;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsNull.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.perscholas.main.sba05.User;
import com.perscholas.main.sba09.UserDAO;

public class JUnitSBA09 {
	private static UserDAO udao;
	private static Boolean databaseIsOnline;
	
	@BeforeClass
	public static void setup() throws ClassNotFoundException, IOException, SQLException {
		System.out.println("SETTING UP");
		udao = new UserDAO();
		udao.testConnection();
		databaseIsOnline = true;
		udao.createDB();
		udao.createUser(new User(1, "John", "john12345", 100.0, 100.0));
		udao.createUser(new User(2, "Jill", "jill12345", 78.0, 86.0));
		System.out.println();
	}
	
	@AfterClass
	public static void cleanUp() throws SQLException{
		System.out.println("\nCLEANING UP");
		udao.deleteUser(999);
		udao.deleteUser(1);
		udao.deleteUser(2);
		udao.closeResources();
	}
	
	@Test
	public void testCreateUser() throws SQLException {
		assumeTrue(databaseIsOnline);
		User u = new User(999, "John", "applesbananas", 100.0, 90.0);
		
		assertNotNull(udao.createUser(u));
	}
	
	@Test
	public void testReadUsers() throws ClassNotFoundException, IOException, SQLException {
		assumeTrue(databaseIsOnline);
		List<User> tmpList = udao.readUsers();
		
		assertThat(tmpList, is(notNullValue()));
		assertThat(tmpList.size(), is(2));
		assertThat(tmpList.get(0).getName(), is("John"));
		assertThat(tmpList.get(1).getName(), is("Jill"));
	}
	
	@Test
	public void testUpdateUser() throws SQLException {
		assumeTrue(databaseIsOnline);
		User u = new User(1, "John", "john12345", 88.0, 96.0);
		assertTrue(udao.updateUser(u));
	}
	
	@Test
	public void testDeleteUser() throws SQLException {
		assumeTrue(databaseIsOnline);
		User u = new User(1, "John", "john12345", 100.0, 100.0);
		
		assertThat(udao.deleteUser(1), is(true));
		udao.createUser(u);
	}
}
