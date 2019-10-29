package com.perscholas.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.connection.MariaDBConnection;
import com.perscholas.models.Staff;

public class StaffDAO {
	private static List<Staff> jobList = new ArrayList<Staff>();
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	public StaffDAO() throws ClassNotFoundException, IOException, SQLException {
		conn = new MariaDBConnection().getConnection();
		stmt = null;
		rs = null;
	}
	
	public void testConnection() {
		MariaDBConnection mariadbConnection = new MariaDBConnection();
		try {
			mariadbConnection.getConnection();
			System.out.println("Connected to Maria DB!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Database connection failed.");
		}
	}
	
	// CREATE
	public boolean createStaff(Staff staff) throws SQLException {
		boolean isSuccessful = false;
		
		String insertQuery = "INSERT INTO staff "
				+ "(email, name, phone) "
				+ "values (?, ?, ?)";
		
		String[] col = {"companyId"};
		
		MariaDBConnection mariadb = new MariaDBConnection();
		
		try {
			conn = mariadb.getConnection();
			stmt = conn.prepareStatement(insertQuery, col);

			stmt.setString(1, staff.getEmail());
			stmt.setString(2, staff.getName());
			stmt.setString(3, staff.getPhone());

			stmt.executeUpdate();
			
			isSuccessful = true;
			
			System.out.println("Staff " + staff.getEmail() + " created!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccessful;
	}
	
	// READ
	public List<Staff> readStaff() throws ClassNotFoundException, IOException, SQLException {
//		Connection conn = new MariaDBConnection().getConnection();
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM staff";
		
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			String email = rs.getString("email");
			String name = rs.getString("name");
			String phone = rs.getString("phone");;
			
			jobList.add(new Staff(email, name, phone));
		}
		
		return jobList;
	}
	
	// UPDATE
	public Boolean updateStaff(Staff staff) throws SQLException{
		Integer result = null;
		
		String updateString = "update staff "
				+ "set name = ?, phone = ?"
				+ "where email = ?";
		
		MariaDBConnection dbconn = new MariaDBConnection();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			stmt.setString(1, staff.getName());
			stmt.setString(2, staff.getPhone());
			stmt.setString(3, staff.getEmail());
			
			result = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (result > 0) {
			System.out.println("Staff " + staff.getEmail() + " updated!");
			return true;
		}
		return false;
	}
	
	// DESTROY
	public Boolean deleteStaff(String email) throws SQLException{
		Integer result = null;
		
		String updateString = "delete from staff where email = ?";
		
		MariaDBConnection dbconn = new MariaDBConnection();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			stmt.setString(1, email);
			
			result = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (result > 0) {
			System.out.println("Staff " + email + " deleted!");
			return true;
		}
		return false;
	}
	
	public void closeResources() throws SQLException {
		if(conn != null)
			conn.close();
		if(stmt != null)
			stmt.close();
		if(rs != null)
			rs.close();
	}
}
