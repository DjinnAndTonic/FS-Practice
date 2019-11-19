package com.perscholas.project05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.perscholas.project02.MariaDBConnection;

public class QuoteDAO {
	List<Quote> quoteList = new ArrayList<Quote>();
	//CR
	private MariaDBConnection mdb;
	private Connection conn;
	
	public QuoteDAO() throws ClassNotFoundException, IOException, SQLException {
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
	public int createQuote(Quote q) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String insertQuery = "INSERT INTO quote (quoteId, homeId, yearlyPremium, "
				+ "startDate, expiration, active) "
				+ "values (?, ?, ?, ?, ?, ?)";
		
		int id = -1;
		
		try {
			stmt = conn.prepareStatement(insertQuery);

			stmt.setInt(1, q.getQuoteId());
			stmt.setInt(2, q.getHomeId());
			stmt.setDouble(3, q.getYearlyPremium());
			stmt.setDate(4, new java.sql.Date(q.getStartDate().getTime()));
			stmt.setDate(5, new java.sql.Date(q.getExpiration().getTime()));
			stmt.setBoolean(6, q.isActive());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()) {
				id = rs.getInt("homeId");
			}
			
			System.out.println("Quote " + id + " created!");
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
	public void readQuotes() throws ClassNotFoundException, IOException, SQLException {
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM home";
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int qid = rs.getInt(1);
			int hid = rs.getInt(2);
			double premium = rs.getDouble(3);
			Date start = new java.util.Date(rs.getDate(4).getTime());
			Date exp = new java.util.Date(rs.getDate(5).getTime());
			boolean active = rs.getBoolean(6);
			
			quoteList.add(new Quote(qid, hid, premium, start, exp, active));
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
		QuoteDAO hdao = new QuoteDAO();
		hdao.testConnection();
		
		hdao.closeResources();
	}

}
