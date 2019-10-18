package com.perscholas.dao;

import com.perscholas.connection.MariaDBConnection;
import com.perscholas.classes.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAO {
	private MariaDBConnection mdb;
	private Connection conn;
	
	public ProductDAO() throws ClassNotFoundException, IOException, SQLException {
		mdb = new MariaDBConnection();
		conn = mdb.getConnection();
	}
	
	public void testConnection() throws SQLException {
		try {
			conn = mdb.getConnection();
			System.out.println("Connection successful");
		} catch(Exception e) {
			System.out.println("Connection unsuccessful");
		} finally {
			if(conn != null)
				conn.close();
		}
	}
//	
//	public void readFromFile() throws ClassNotFoundException, IOException, SQLException {
//		PreparedStatement stmt = null;
////		ResultSet rs = null;
//		
//		String query = "INSERT INTO product (productName, price) values (?,?)";
//		
//		int ID = -1;
//	    String[] COL = {"productId"};
//		
//		File file = new File("orders.txt");
//		Scanner scan = new Scanner(file);
//		
//		String format = scan.nextLine();
////		System.out.println(format);
//		
//		while(scan.hasNext()) {
//			String line = scan.nextLine();
//			
//			stmt = conn.prepareStatement(query, COL);
//			
//			String[] dbentry = line.split(" ");
//			String name = dbentry[0];
//			double price = Double.parseDouble(dbentry[1]);
//			
//			stmt.setString(1, name);
//			stmt.setDouble(2, price);
//			
//			stmt.executeUpdate();
//		}
//		
//		if (stmt != null) {
//			stmt.close();
//		}
//		
//		scan.close();
//	}
//	
	public List<Product> getAllProducts() throws SQLException {		
		String query = "SELECT * FROM product";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		List<Product> productList = new ArrayList<Product>();
		Product p;
		
		while(rs.next()) {
			p = new Product();
			
			p.setProductId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			
			productList.add(p);
		}
		
		if (stmt != null) {
			stmt.close();
		}
		if (rs != null) {
			rs.close();
		}
		
		return productList;
	}
	
	public Product getSelectedProduct(String name) {
		Product p = new Product();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		String query = "SELECT * FROM product WHERE productName = ?";
		
		try {
			conn = mdb.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				p.setProductId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
			}
		} catch (ClassNotFoundException | IOException | SQLException e)	{
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
		return p;
	}
	
	
	public void closeResources() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		ProductDAO pdao = new ProductDAO();
		
//		pdao.readFromFile();
	}
}
