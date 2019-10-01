package com.perscholas.servlet_demo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.perscholas.servlet_demo.models.Student;

public class StudentDAO {
	private ArrayList<Student> students =new ArrayList<Student>();
	
	public void testConnection() {
		MariaDBConnection mariadbConnection = new MariaDBConnection();
		try {
			mariadbConnection.getConnection();
			System.out.println("Connected to Maria DB!");
		} catch (Exception e) {
			System.out.println("Database connection failed.");
		}
	}
	
	
//	Method that adds Student objects into the
//	ArrayList of Student objects by using
//	the rows inside the database.
	public void createStudents() throws SQLException, IOException, ClassNotFoundException {
//		Create connection object using properties in the MariaDBConnection class
		Connection conn = new MariaDBConnection().getConnection();
		Statement statement = conn.createStatement();
		
//		String that contains the SQL statement for the query
		String query = "SELECT * FROM students";
		
//		ResultSet object created. The object is a set of data
//		that contains the information from the executed query.
//		In this case, the result set will contain the rows
//		the SQL query returns. 
		ResultSet rs = statement.executeQuery(query);
		
//		iterate through the rows in the data/result set
		while(rs.next()) {
//			assign variables accordingly
			int studentId = rs.getInt("studentId");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String courseSelection = rs.getString("courseSelection");
			String town = rs.getString("town");
			
//			add and create new Student objects
//			store in an arraylist of Student objects
			students.add(new Student(studentId, name, email, courseSelection, town));
		}
	
//		close the objects
		rs.close();
		conn.close();
		statement.close();
	}
	
//	Method to add a new row to the database.
//	Parameter: Student object
	public int addStudent(Student s) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
//		SQL statement to be executed.
//		(?,?,?,?) are place-holders for (name, email, courseSelection, town) respective
//		values.
		String insertQuery = "INSERT INTO students (name, email, courseSelection, town) values (?, ?, ?, ?)";
		
		int id = -1;
		
//		Target column.
		String[] col = {"studentID"};
		
		MariaDBConnection mariadb = new MariaDBConnection();
		
		try {
//			Establish connection to server
			conn = mariadb.getConnection();
			stmt = conn.prepareStatement(insertQuery, col);
			
//			Fill in the place-holders with the values of
//			the Student object.
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getCourseSelection());
			stmt.setString(4, s.getTown());
			
//			Execute the statement
			stmt.executeUpdate();
			
//			Set rs to the dataset generated from
//			executing the statement.
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()) {
				
//				Sets the id variable equal to the primary key
//				(which is studentID) of the table
				id = rs.getInt("studentID");
			}
			
//			Print Line statement to verify the creation
//			of a new row.
//			If id is negative, then a row was not
//			properly added.
			System.out.println("Student " + id + " created!");
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
		
//		Returns the (int) id of the new student added
		return id;
	}
	
//	Iterate through the ArrayList of Student objects
//	and prints out each object in the ArrayList by
//	calling the toString() method of the Student class
	public void displayStudents() {
		for(Student s: students)
			System.out.println(s);
	}
	
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		StudentDAO s = new StudentDAO();
//		s.testConnection();
		s.addStudent(new Student("Sweeney", "sTodd@fleetst.com", "Biology", "London"));
		s.createStudents();
		s.displayStudents();
	}
}
