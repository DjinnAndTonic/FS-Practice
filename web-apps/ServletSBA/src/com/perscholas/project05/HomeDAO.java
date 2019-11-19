package com.perscholas.project05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.perscholas.project02.MariaDBConnection;

public class HomeDAO {
	//C
	private MariaDBConnection mdb;
	private Connection conn;
	
	public HomeDAO() throws ClassNotFoundException, IOException, SQLException {
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
	public int createHome(Home h) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		PreparedStatement stmt2 = conn.prepareStatement("SELECT max(homeId)+1 FROM home");
        rs = stmt2.executeQuery();
        int home_id = -1 ;
        while(rs.next())
        {
            home_id = rs.getInt(1);
        }
		
		String insertQuery = "INSERT INTO home (homeId, userId, address1, "
				+ "address2, city, state, zip, yearBuilt, homeValue) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int id = -1;
//		String[] col = {"homeId"};
		
		try {
			stmt = conn.prepareStatement(insertQuery);

			stmt.setInt(1, home_id);
			stmt.setInt(2, h.getUserId());
			stmt.setString(3, h.getAddress1());
			stmt.setString(4, h.getAddress2());
			stmt.setString(5, h.getCity());
			stmt.setString(6, h.getState());
			stmt.setInt(7, h.getZip());
			stmt.setInt(8, h.getYearBuilt());
			stmt.setDouble(9, h.getHomeValue());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()) {
				id = rs.getInt("homeId");
			}
			
			System.out.println("Home " + id + " created!");
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
	public void readHomes() throws ClassNotFoundException, IOException, SQLException {
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM home";
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int userId = rs.getInt("userId");
			String fName = rs.getString("firstName");
			String lName = rs.getString("lastName");
			String email = rs.getString("userEmail");
			String pass = rs.getString("userPassword");
			java.util.Date dob = new java.util.Date(rs.getDate("dob").getTime());
			
		}
		
		rs.close();
		stmt.close();
	}
	
	
	public void closeResources() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		HomeDAO hdao = new HomeDAO();
		hdao.testConnection();
		
		hdao.closeResources();
	}
}
