package com.perscholas.main.sba09;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.main.sba05.User;

public class UserDAO {
	private static List<User> userList = new ArrayList<User>();
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	public UserDAO() throws ClassNotFoundException, IOException, SQLException {
		conn = new MariaDBConnection().getConnection();
		stmt = null;
		rs = null;
	}
	
	public void createDB() throws ClassNotFoundException, IOException, SQLException {
		Statement stmt = conn.createStatement();
		
		String query = "CREATE DATABASE IF NOT EXISTS `junitsba`;";
		String query2 = "USE `JUnitSBA`;";
		String query3 = "CREATE TABLE IF NOT EXISTS `users` (\r\n" + 
				"  `userId` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
				"  `name` varchar(50) DEFAULT NULL,\r\n" + 
				"  `password` varchar(25) DEFAULT NULL,\r\n" + 
				"  `javaScore` double DEFAULT NULL,\r\n" + 
				"  `sqlScore` double DEFAULT NULL,\r\n" + 
				"  PRIMARY KEY (`userId`)\r\n" + 
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
		
		stmt.executeQuery(query);
		stmt.execute(query2);
		stmt.execute(query3);
		
//		conn.close();
		stmt.close();
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
	public int createUser(User u) throws SQLException {
		
		String insertQuery = "INSERT INTO users (userId, name, password, javaScore, sqlScore) values (?, ?, ?, ?, ?)";
		
		int id = -1;
		
		String[] col = {"userId"};
		
		MariaDBConnection mariadb = new MariaDBConnection();
		
		try {
			conn = mariadb.getConnection();
			stmt = conn.prepareStatement(insertQuery, col);

			stmt.setInt(1, u.getUserId());
			stmt.setString(2, u.getName());
			stmt.setString(3, u.getPassword());
			stmt.setDouble(4, u.getJavaScore());
			stmt.setDouble(5, u.getSqlScore());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()) {
				id = rs.getInt("userId");
			}
			
			System.out.println("User " + id + " created!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	// READ
	public List<User> readUsers() throws ClassNotFoundException, IOException, SQLException {
//		Connection conn = new MariaDBConnection().getConnection();
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM users";
		
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int userId = rs.getInt("userId");
			String name = rs.getString("name");
			String password = rs.getString("password");
			double javaScore = rs.getDouble("javaScore");
			double sqlScore = rs.getDouble("sqlScore");
			
			userList.add(new User(userId, name, password, javaScore, sqlScore));
		}
		
		return userList;
	}
	
	// UPDATE
	public Boolean updateUser(User u) throws SQLException{
		Integer result = null;
		
		String updateString = "update users "
				+ "set name = ?, password = ? , javaScore = ?, sqlScore = ?"
				+ "where userId = ?";
		
		MariaDBConnection dbconn = new MariaDBConnection();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPassword());
			stmt.setDouble(3, u.getJavaScore());
			stmt.setDouble(4, u.getSqlScore());
			stmt.setInt(5, u.getUserId());
			
			result = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (result > 0) {
			System.out.println("User " + u.getUserId() + " updated!");
			return true;
		}
		return false;
	}
	
	// DESTROY
	public Boolean deleteUser(int id) throws SQLException{
		Integer result = null;
		
		String updateString = "delete from users where userId = ?";
		
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
		
		if (result > 0) {
			System.out.println("User " + id + " deleted!");
			return true;
		}
		return false;
	}
	
	public void getUser(String n) throws SQLException, ClassNotFoundException, IOException {
//		Connection conn = new MariaDBConnection().getConnection();
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM users WHERE name = '"+n+"'";
		
		ResultSet rs = stmt.executeQuery(query);
		
		User u = new User();
		
		while(rs.next()) {
			u.setUserId(rs.getInt("userId"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setJavaScore(rs.getDouble("javaScore"));
			u.setSqlScore(rs.getDouble("sqlScore"));
		}
		
		System.out.println(u);
	}
	
	public void closeResources() throws SQLException {
		if(conn != null)
			conn.close();
		if(stmt != null)
			stmt.close();
		if(rs != null)
			rs.close();
	}
	
	public static void printCourses() {
		for(User u : userList) {
			System.out.println(u);
		}
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		UserDAO u = new UserDAO();
//		u.testConnection();
//		u.createDB();
	}
}
