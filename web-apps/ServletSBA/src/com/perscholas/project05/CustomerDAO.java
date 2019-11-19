package com.perscholas.project05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.project02.MariaDBConnection;

public class CustomerDAO {
	// CR
	private static List<Customer> customerList = new ArrayList<Customer>();
	private MariaDBConnection mdb;
	private Connection conn;
	
	public CustomerDAO() throws ClassNotFoundException, IOException, SQLException {
		mdb = new MariaDBConnection();
		conn = mdb.getConnection();
	}
	public void testConnection() {
		
		try {
			conn = mdb.getConnection();
			System.out.println("Connected to Maria DB!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Database connection failed.");
		}
	}
	
	// CREATE
	public int createCustomer(Customer c) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		PreparedStatement stmt2 = conn.prepareStatement("SELECT max(userId)+1 FROM customers");
        rs = stmt2.executeQuery();
        int user_id = -1 ;
        while(rs.next())
        {
            user_id = rs.getInt(1);
        }
		
		String insertQuery = "INSERT INTO customers (userId, firstName, lastName, userEmail, userPassword, dob) values (?, ?, ?, ?, ?, ?)";
		
		int id = -1;
		
		String[] col = {"userId"};
		
		try {
			stmt = conn.prepareStatement(insertQuery, col);

			stmt.setInt(1, user_id);
			stmt.setString(2, c.getFirstName());
			stmt.setString(3, c.getLastName());
			stmt.setString(4, c.getUserEmail());
			stmt.setString(5, c.getUserPassword());
			stmt.setDate(6, new java.sql.Date(c.getDob().getTime()));

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()) {
				id = rs.getInt("userId");
			}
			
			System.out.println("Customer " + id + " created!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}
		
		return id;
	}
	
	// READ
	public void readCustomers() throws ClassNotFoundException, IOException, SQLException {
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM customers";
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int userId = rs.getInt("userId");
			String fName = rs.getString("firstName");
			String lName = rs.getString("lastName");
			String email = rs.getString("userEmail");
			String pass = rs.getString("userPassword");
			java.util.Date dob = new java.util.Date(rs.getDate("dob").getTime());
			
			customerList.add(new Customer(userId, fName, lName, email, pass, dob));
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
	
	public Customer getCustomer(String n) throws SQLException, ClassNotFoundException, IOException {
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM customers WHERE userEmail = '"+n+"'";
		
		ResultSet rs = stmt.executeQuery(query);
		
		Customer c = new Customer();
		
		while(rs.next()) {
			c.setUserId(rs.getInt(1));
			c.setFirstName(rs.getString(2));
			c.setLastName(rs.getString(3));
			c.setUserEmail(rs.getString(4));
			c.setUserPassword(rs.getString(5));
			c.setDob(new java.util.Date(rs.getDate(6).getTime()));
		}
		
		return c;
	}
	
	public static void printCustomers() {
		for(Customer c : customerList) {
			System.out.println(c);
		}
	}
	
	public void closeResources() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		CustomerDAO c = new CustomerDAO();
		c.testConnection();
		
		c.closeResources();
	}

}
