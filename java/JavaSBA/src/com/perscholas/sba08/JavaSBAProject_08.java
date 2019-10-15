package com.perscholas.sba08;

import java.io.IOException;
import java.sql.SQLException;

/*Write an application that includes an Event class that has event ID, 
 * name, description, and date/time (java.util.Date). 
 * Create an “events” table and save the event data to a database 
 * (date must be converted to java.sql.Data.)*/
public class JavaSBAProject_08 {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		EventDAO edao = new EventDAO();
		
		edao.createTable();
		edao.addEvent(new Event(1, "SBA", "PS Java SBA", new java.util.Date()));
	}
}
