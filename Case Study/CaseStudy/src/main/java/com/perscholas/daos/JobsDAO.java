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
import com.perscholas.models.Job;

public class JobsDAO {
	private static List<Job> jobList = new ArrayList<Job>();
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	public JobsDAO() throws ClassNotFoundException, IOException, SQLException {
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
	public boolean createJob(Job job) throws SQLException {
		boolean isSuccessful = false;
		
		String insertQuery = "INSERT INTO jobs "
				+ "(jobId, companyName, alumEmail) "
				+ "values (?, ?, ?)";
		
		String[] col = {"jobId"};
		
		MariaDBConnection mariadb = new MariaDBConnection();
		
		try {
			conn = mariadb.getConnection();
			stmt = conn.prepareStatement(insertQuery, col);

			stmt.setInt(1, job.getJobId());
			stmt.setString(2, job.getCompanyName());
			stmt.setString(3, job.getAlumEmail());

			stmt.executeUpdate();
			
			isSuccessful = true;
			
			System.out.println("Job " + job.getJobId() + " created!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccessful;
	}
	
	// READ
	public List<Job> readJobs() throws ClassNotFoundException, IOException, SQLException {
//		Connection conn = new MariaDBConnection().getConnection();
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM jobs";
		
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("jobId");
			String name = rs.getString("companyName");
			String email = rs.getString("alumEmail");;
			
			jobList.add(new Job(id, name, email));
		}
		
		return jobList;
	}
	
	// UPDATE
	public Boolean updateJob(Job job) throws SQLException{
		Integer result = null;
		
		String updateString = "update jobs "
				+ "set companyName = ?, alumEmail = ?"
				+ "where jobId = ?";
		
		MariaDBConnection dbconn = new MariaDBConnection();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			stmt.setString(1, job.getCompanyName());
			stmt.setString(2, job.getAlumEmail());
			stmt.setInt(3, job.getJobId());
			
			result = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (result > 0) {
			System.out.println("Job " + job.getJobId() + " updated!");
			return true;
		}
		return false;
	}
	
	// DESTROY
	public Boolean deleteJob(int id) throws SQLException{
		Integer result = null;
		
		String updateString = "delete from jobs where jobId = ?";
		
		MariaDBConnection dbconn = new MariaDBConnection();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			stmt.setInt(1, id);
			
			result = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (result > 0) {
			System.out.println("Job " + id + " deleted!");
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
