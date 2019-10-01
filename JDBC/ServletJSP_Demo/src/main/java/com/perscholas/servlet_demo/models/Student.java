package com.perscholas.servlet_demo.models;

public class Student {
//	Attributes
	private int studentId;
	private String name, email, courseSelection, town;
	public int getStudentId() {
		return studentId;
	}
	
//	Constructors
	public Student(int studentId, String name, String email, String courseSelection, String town) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.courseSelection = courseSelection;
		this.town = town;
	}
	
	public Student() {
		studentId = 0;
		name = null;
		email = null;
		courseSelection = null;
		town = null;
	}
	
	public Student(String name, String email, String courseSelection, String town) {
		super();
		this.name = name;
		this.email = email;
		this.courseSelection = courseSelection;
		this.town = town;
	}

	//	Setters/Getters
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourseSelection() {
		return courseSelection;
	}
	public void setCourseSelection(String courseSelection) {
		this.courseSelection = courseSelection;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
//	toString method.
//	returns studentId, name, email, 
//	course selection, and town as a String
	public String toString() {
		return studentId + ": " + name + " " + email + " " + courseSelection + " " + town;
	}

}
