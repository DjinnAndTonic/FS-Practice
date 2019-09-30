package com.bnguyen.servlet;
import com.bnguyen.servletmodels.User;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

public class UserDAO {
	ArrayList<User> userList = new ArrayList<User>();
	
	public Connection testConnection() {
		MariaDBConnection mariadbConnection = new MariaDBConnection();
		try {
			return mariadbConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void createUsers(Connection conn) throws SQLException {
		Statement stmt = null;
		String query = "SELECT * FROM credentials";
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			userList.add(new User(rs.getString("username"), rs.getString("password")));
		}
		
		rs.close();
		stmt.close();
	}
	
	public static void main(String[] args) {
		MariaDBConnection mariadbConnection = new MariaDBConnection();
		UserDAO ud = new UserDAO();
		System.out.println(new UserDAO().testConnection());
	}
}
