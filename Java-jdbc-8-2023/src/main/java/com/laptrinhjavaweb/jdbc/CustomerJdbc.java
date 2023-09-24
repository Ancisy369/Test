package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;


public class CustomerJdbc {

/*	static final String DB_URL = "jdbc:mysql://localhost:3306/corejava072023";
	static final String USER = "root";
	static final String PASS = "12345";*/
	//static final String QUERY = "SELECT * FROM building";

	public static void main(String[] args) {
		//beginner 
		//input
		String fullname = null;
		String phone = null;
		
		//JDBC Beginner
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
			try {
			StringBuilder query = new StringBuilder("SELECT * FROM customer" + SystemConstant.ONE_EQUAL_ONE);
			if(!StringUtils.isNullOrEmpty(fullname)) {
				query.append("and fullname like '%" + fullname + "%'");
			}
			if(!StringUtils.isNullOrEmpty(phone)) {
				query.append("and phone like '%" + phone + "%'");
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				System.out.print("ID: " + rs.getLong("id") + ", Type : " + rsmd.getColumnTypeName(1));
				System.out.print(", fullname: " + rs.getString("fullname"));
				System.out.println(", phone: " + rs.getString("phone"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error" + e.getMessage());
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error : " + e.getMessage());
			}
		}
		
		
		// Experienced
		/*try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			while (rs.next()) {
				// Display values
				System.out.print("Name: " + rs.getString("name"));
				System.out.print(", Street: " + rs.getString("street"));
				System.out.print(", District: " + rs.getString("district"));
				System.out.println(", Ward: " + rs.getString("ward"));
				System.out.println(", FloorArea " + rs.getString("floorarea"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
		
	}

}
