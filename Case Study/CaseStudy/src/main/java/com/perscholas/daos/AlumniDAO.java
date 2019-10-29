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
import com.perscholas.models.Alumnus;

public class AlumniDAO {
	private static List<Alumnus> alumList = new ArrayList<Alumnus>();
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	public AlumniDAO() throws ClassNotFoundException, IOException, SQLException {
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
	public boolean createAlumnus(Alumnus alum) throws SQLException {
		boolean isSuccessful = false;
		
		String insertQuery = "INSERT INTO alumni "
				+ "(email, name, address, phone, city, state, zip) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		
		String[] col = {"email"};
		
		MariaDBConnection mariadb = new MariaDBConnection();
		
		try {
			conn = mariadb.getConnection();
			stmt = conn.prepareStatement(insertQuery, col);

			stmt.setString(1, alum.getEmail());
			stmt.setString(2, alum.getName());
			stmt.setString(3, alum.getAddress());
			stmt.setString(4, alum.getPhone());
			stmt.setString(5, alum.getCity());
			stmt.setString(6, alum.getState());
			stmt.setString(7, alum.getZip());

			stmt.executeUpdate();
			
			isSuccessful = true;
			
			System.out.println("Alumnus " + alum.getEmail() + " created!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccessful;
	}
	
	// READ
	public List<Alumnus> readAlumnus() throws ClassNotFoundException, IOException, SQLException {
//		Connection conn = new MariaDBConnection().getConnection();
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM alumni";
		
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			String email = rs.getString("email");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String phone = rs.getString("phone");
			String city = rs.getString("city");
			String state = rs.getString("state");
			String zip = rs.getString("zip");
			
			alumList.add(new Alumnus(email, name, address, phone, city, state, zip));
		}
		
		return alumList;
	}
	
	// UPDATE
	public Boolean updateAlumnus(Alumnus alum) throws SQLException{
		Integer result = null;
		
		String updateString = "update alumni "
				+ "set name = ? , address = ?, phone = ?, city = ?, state = ?, zip = ?"
				+ "where email = ?";
		
		MariaDBConnection dbconn = new MariaDBConnection();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			stmt.setString(1, alum.getName());
			stmt.setString(2, alum.getAddress());
			stmt.setString(3, alum.getPhone());
			stmt.setString(4, alum.getCity());
			stmt.setString(5, alum.getState());
			stmt.setString(6, alum.getZip());
			stmt.setString(7, alum.getEmail());
			
			
			result = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (result > 0) {
			System.out.println("Alumnus " + alum.getEmail() + " updated!");
			return true;
		}
		return false;
	}
	
	// DESTROY
	public Boolean deleteAlumnus(String email) throws SQLException{
		Integer result = null;
		
		String updateString = "delete from alumni where email = ?";
		
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
			System.out.println("Alumnus " + email + " deleted!");
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
