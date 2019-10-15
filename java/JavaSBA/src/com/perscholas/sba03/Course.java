package com.perscholas.sba03;

/*Make a class named Course and include attributes for id, course name, 
 * course description. Create a no-arg constructor and a constructor 
 * with 3 arguments. Create the getters and setters. Override the 
 * default toString method to return a String that lists out the 
 * instance data. */
public class Course {
	private int id;
	private String name, description;
	
	public Course() {
		id = -1;
		name = "";
		description = "";
	}


	public Course(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "Course ID: " + getId() + "\tCourse Name: " + getName() + "\n" +
				"Description: " + getDescription();
	}
	
}
