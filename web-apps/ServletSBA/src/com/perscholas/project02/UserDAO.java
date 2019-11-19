package com.perscholas.project02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private MariaDBConnection mdb;
	private Connection conn;
	
	public UserDAO() throws ClassNotFoundException, IOException, SQLException {
		mdb = new MariaDBConnection();
		conn = mdb.getConnection();
	}
	
	public void testConnection() throws SQLException {
		try {
			conn = mdb.getConnection();
			System.out.println("Connection successful");
		} catch(Exception e) {
			System.out.println("Connection unsuccessful");
		}
	}
	
	public boolean updateUser(User u) throws SQLException {
		int updatedInt = -1;
		PreparedStatement stmt = null;
		
		String query = "UPDATE users "
				+ "SET username = ?, pass_word = ? "
				+ "WHERE userId = ?";
		
		System.out.println(u.getUserId());
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());
		
		try {
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setInt(3, u.getUserId());
			
			updatedInt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(updatedInt > 0)
			return true;
		return false;
	}
	
	public User findUserByName(String name) {
		User u = new User();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		String query ="SELECT * FROM users WHERE username=?";
		
		try {
			conn = mdb.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
			} else {
				return null;
			}
		} catch (ClassNotFoundException | IOException | SQLException e)	{
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
		return u;
	}
	
	public void closeResources() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		UserDAO udao = new UserDAO();
		
		udao.testConnection();
		System.out.println(udao.findUserByName("user"));
		
		udao.updateUser(new User(2, "username2", "pass2"));
		udao.closeResources();
	}
}
