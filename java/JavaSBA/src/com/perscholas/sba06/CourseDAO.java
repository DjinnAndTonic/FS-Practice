package com.perscholas.sba06;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.perscholas.sba03.Course;

/*Make a Course DAO and write a method to make a connection to MariaDB. 
 * Write a main method to verify that the connection has been made.
 * Add all of the CRUD methods to the Course DAO.*/

public class CourseDAO {
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	
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
	public int createCourse(Course c) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String insertQuery = "INSERT INTO courses (id, name, description) values (?, ?, ?)";
		
		int id = -1;
		
		String[] col = {"id"};
		
		MariaDBConnection mariadb = new MariaDBConnection();
		
		try {
			conn = mariadb.getConnection();
			stmt = conn.prepareStatement(insertQuery, col);

			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getName());
			stmt.setString(3, c.getDescription());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()) {
				id = rs.getInt("id");
			}
			
			System.out.println("Course " + id + " created!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		
		return id;
	}
	
	// READ
	public void readCourses() throws ClassNotFoundException, IOException, SQLException {
		Connection conn = new MariaDBConnection().getConnection();
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM courses";
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String desc = rs.getString("description");
			
			courseList.add(new Course(id, name, desc));
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
	
	// UPDATE
	public Boolean updateCourse(Course c) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;
		
		String updateString = "update courses "
				+ "set name = ?, description = ? "
				+ "where id = ?";
		
		MariaDBConnection dbconn = new MariaDBConnection();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getDescription());
			stmt.setInt(3, c.getId());
			
			result = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)	conn.close();
			if (stmt != null)	stmt.close();
		}
		
		if (result > 0)		return true;
		return false;
	}
	
	// DESTROY
	public Boolean deleteCourse(int id) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer result = null;
		
		String updateString = "delete from courses where id = ?";
		
		MariaDBConnection dbconn = new MariaDBConnection();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			stmt.setInt(1, id);
			
			result = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)	conn.close();
			if (stmt != null)	stmt.close();
		}
		
		if (result > 0)		return true;
		return false;
	}
	
	public void getCourse(String n) throws SQLException, ClassNotFoundException, IOException {
		Connection conn = new MariaDBConnection().getConnection();
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM courses WHERE name = '"+n+"'";
		
		ResultSet rs = stmt.executeQuery(query);
		
		Course c = new Course();
		
		while(rs.next()) {
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setDescription(rs.getString("description"));
		}
		
		System.out.println(c);
	}
	
	public static void printCourses() {
		for(Course c : courseList) {
			System.out.println(c);
		}
	}
	public static void main(String[] args) throws SQLException {
		CourseDAO c = new CourseDAO();
		c.testConnection();
	}
}
