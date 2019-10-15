package com.perscholas.sba08;

import java.util.Date;

/*Write an application that includes an Event class that has event ID, 
 * name, description, and date/time (java.util.Date). 
 * Create an “events” table and save the event data to a database 
 * (date must be converted to java.sql.Data.)*/
public class Event {
	private int id;
	private String name, description;
	private Date date;
	
	public Event(int id, String name, String description, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
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
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
