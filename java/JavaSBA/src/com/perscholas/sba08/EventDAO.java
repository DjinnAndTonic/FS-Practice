package com.perscholas.sba08;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.perscholas.sba06.MariaDBConnection;

/*Write an application that includes an Event class that has event ID, 
 * name, description, and date/time (java.util.Date). 
 * Create an “events” table and save the event data to a database 
 * (date must be converted to java.sql.Data.)*/
public class EventDAO {
	public void createTable() throws ClassNotFoundException, IOException, SQLException {
		Connection conn = new MariaDBConnection().getConnection();
		Statement stmt = conn.createStatement();
		
		String query = "CREATE OR REPLACE TABLE `events` (\r\n" + 
				"	`id` int NOT NULL AUTO_INCREMENT KEY, \r\n" + 
				"	`name` varchar(50), \r\n" + 
				"	`description` varchar(255),\r\n" + 
				"	`whenat` date\r\n" + 
				")";
		
		ResultSet rs = stmt.executeQuery(query);
	}
	
	public void addEvent(Event e) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = new MariaDBConnection().getConnection();
		
		String insertQuery = "INSERT INTO events (id, name, description, whenat) values (?, ?, ?, ?)";
		String[] col = {"id"};
		
		PreparedStatement stmt = conn.prepareStatement(insertQuery, col);
		
		java.sql.Date sqlDate = new java.sql.Date(e.getDate().getTime());
		
		stmt.setInt(1, e.getId());
		stmt.setString(2, e.getName());
		stmt.setString(3, e.getDescription());
		stmt.setDate(4, sqlDate);
		
		stmt.executeUpdate();
		
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}
	
}
