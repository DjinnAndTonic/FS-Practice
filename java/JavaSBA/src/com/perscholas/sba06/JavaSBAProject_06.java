package com.perscholas.sba06;

import java.io.IOException;
import java.sql.SQLException;

import com.perscholas.sba03.Course;

/* Create a driver class to demonstrate each method:
 * Insert 3 courses into the database.
 * Retrieve/read all courses and print them using a loop
 * Find 1 course by name and print the details of the course.
 * Update the first course in the database.
 * Delete a course by ID*/
public class JavaSBAProject_06 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException
	{
		CourseDAO cDAO = new CourseDAO();
		
		cDAO.createCourse(new Course(1, "Java", "java language"));
		cDAO.createCourse(new Course(2, "Python", "python language"));
		cDAO.createCourse(new Course(3, "C#", "c# language"));
		System.out.println();
		
		cDAO.readCourses();
		CourseDAO.printCourses();
		System.out.println();
		
		cDAO.getCourse("Java");
		System.out.println();
		
		cDAO.updateCourse(new Course(1, "JavaScript", "UPDATED java to javascript"));
		
		cDAO.deleteCourse(3);
	}

}
