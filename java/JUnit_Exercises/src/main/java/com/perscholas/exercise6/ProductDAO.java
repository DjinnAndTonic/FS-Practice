package com.perscholas.exercise6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private Connection conn = null;
	private MariaDBConnection dbc = new MariaDBConnection();
	
	public void testConnection() throws SQLException {
		try {
			conn = dbc.getConnection();
			System.out.println("Connection successful");
		} catch(Exception e) {
			System.out.println("Connection unsuccessful");
		} finally {
			if(conn != null)
				conn.close();
		}
	}
	
//	//****************getAllUsers() method*****************
//
	public List<Product> getAllProducts() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Product u = null;
		List<Product> productList = null;

		// Assign query string to a variable
		String qString = "select * from product";

		// Create MariaDBConnection class instance
		MariaDBConnection mdbc = new MariaDBConnection();

		// Begin try/catch block to query the database
		try
		{
			// Connect to database
			conn = mdbc.getConnection();
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
			// Create Statement instance/object
			stmt = conn.createStatement();
		
			// Run query and assign to the ResultSet instance
			rs = stmt.executeQuery(qString);
			//Create list to hold Product objects
			productList = new ArrayList<Product>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new product
				u = new Product();
				// Assign columns/fields to related fields in the Product object
				// 1,2 and 3 represent column numbers/positions
				u.setProductId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPrice(rs.getDouble(3));
				// Add the product to the list
				productList.add(u);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return productList;
	} // End of getAllUsers method	
//	
//	//****************registerUser() method*****************
//	
	public Integer registerProduct(Product product) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into product (productName, price) values (?,?)";
		
	    int ID = -1;
	    String[] COL = {"productId"};
	    
	    MariaDBConnection mdbc = new MariaDBConnection();
	    
	    try
	    {
	        conn = mdbc.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, product.getName());
	        stmt.setDouble(2, product.getPrice());
	        
	        stmt.executeUpdate();
	        
	        rs = stmt.getGeneratedKeys();
	        if(rs != null && rs.next()) {
	            ID = rs.getInt(1);
	        }
	        System.out.println(ID);
	    }
	    catch (SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	    
		return ID;
	} // End of registerUser() method
//	
//	//****************getUserById() method*****************
//
//	public Product getUserById(int userId) throws ClassNotFoundException, IOException, SQLException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		Product u = null;
//		
//		// Assign query string to variable
//		String qString = "select * from users where user_id = ?";
//		
//		// Create MariaDBConnection class instance
//		MariaDBConnection mdbc = new MariaDBConnection();
//		
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mdbc.getConnection();
//			stmt = conn.prepareStatement(qString);
//			
//			// Set query parameters (?)
//			stmt.setInt(1, userId); // user_id if from String parameter passed to method
//			
//			// Run query and assign to ResultSet
//			rs = stmt.executeQuery();
//			
//			// Retrieve ResultSet and assign to new Product
//			if (rs.next()) {
//				u = new Product();
//				u.setProductId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setPrice(rs.getString(3));
//			}
//		}
//		catch (ClassNotFoundException | IOException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//			e.getStackTrace();
//		}
//		finally
//		{
//			if (rs != null) {
//				rs.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return u;
//	} // End of getUserById() method
//	
//	//****************getUserByName or login method*****************
//
//	public Product getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		Product u = null;
//		
//		// Assign query string to variable
//		String qString = "select * from users where name = ?";
//		
//		// Create MariaDBConnection class instance
//		MariaDBConnection mdbc = new MariaDBConnection();
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mdbc.getConnection();
//			stmt = conn.prepareStatement(qString);
//			
//			// Set query parameters (?)
//			stmt.setString(1, name); // user_id if from String parameter passed to method
//			// Run query and assign to ResultSet
//			rs = stmt.executeQuery();
//			// Retrieve ResultSet and assign to new Product
//			if (rs.next()) {
//				u = new Product();
//				u.setProductId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setPrice(rs.getString(3));
//			}
//		}
//		catch (ClassNotFoundException | IOException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//			System.out.println(e.getStackTrace());
//		}
//		finally
//		{
//			if (rs != null) {
//				rs.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return u;
//	}  // End of getUserByName() method
//	
//	//****************updateUser() method*****************
//	
//	public Boolean updateUser(Product u) throws SQLException, ClassNotFoundException, IOException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		Integer updateResult = null;
//		
//		// Assign update string to variable
//		String updateString = "update users "
//				+ "set name = ?, password = ? "
//				+ "where user_id = ?";
//		
//		// Create MariaDBConnection class instance
//		MariaDBConnection mdbc = new MariaDBConnection();
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mdbc.getConnection();
//			stmt = conn.prepareStatement(updateString);
//			
//			// Set query parameters (?)
//			stmt.setString(1, u.getName());
//			stmt.setString(2, u.getEmail());
//			stmt.setInt(3, u.getUserId());
//			// Run query and assign to ResultSet
//			updateResult = stmt.executeUpdate();
//		}
//		catch (ClassNotFoundException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//		}
//		finally
//		{
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		if (updateResult > 0) {
//			return true;
//		}
//		return false;
//	} // End of updateUser() method
//	
//	//****************removeUser() method (i.e., delete)*****************
//	
//	public Boolean removeUser(int userId) throws IOException, SQLException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		Integer updateResult = null;
//		
//		// Assign delete string to variable
//		String deleteString = "delete from users where user_id = ?";
//		
//		// Create MariaDBConnection class instance
//		MariaDBConnection mdbc = new MariaDBConnection();
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mdbc.getConnection();
//			stmt = conn.prepareStatement(deleteString);
//			
//			// Set query parameters (?)
//			stmt.setInt(1, userId);
//			// Run query and assign to ResultSet
//			updateResult = stmt.executeUpdate();
//		}
//		catch (ClassNotFoundException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//		}
//		finally
//		{
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		if (updateResult > 0) {
//			return true;
//		}
//		return false;
//	} // End of removeUser() method
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		ProductDAO pdao = new ProductDAO();
//		pdao.testConnection();
		
		List<Product> pList = pdao.getAllProducts();
		for(Product p: pList) {
			System.out.println(p.getName());
		}
		
		Product p = new Product();
		p.setName("Dr. Pepper");
		p.setPrice(1.59);
		pdao.registerProduct(p);
		
	}
	
} // End of UserDAO class