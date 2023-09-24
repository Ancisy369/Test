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


public class BuildingJdbc {

/*	static final String DB_URL = "jdbc:mysql://localhost:3306/corejava072023";
	static final String USER = "root";
	static final String PASS = "12345";*/
	//static final String QUERY = "SELECT * FROM building";

	public static void main(String[] args) {

		/*try {
			Integer value = 0/10;
			System.out.println(value);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("anh yeu em");
		} catch (ClassNotFoundException e) {
			System.out.println("Thiếu file rar rồi anh gì ơi");
		} catch (Exception e) {
			System.out.println("lỗi ngoại lệ rồi anh gì ơi");
		}*/
		//beginner 
		//input
		String name = null;
		String street = null;
		String ward = null;
		String district = null;
		Integer floorArea = null;
		//Integer numberOfBasement = null;
		
		//JDBC Beginner
/*		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

			try {
			StringBuilder query = new StringBuilder("SELECT * FROM building" + SystemConstant.ONE_EQUAL_ONE);
			if(!StringUtils.isNullOrEmpty(name)) {
				query.append("and name like '%" + name + "%'");
			}
			if(!StringUtils.isNullOrEmpty(street)) {
				query.append("and street like '%" + street + "%'");
			}
			if(!StringUtils.isNullOrEmpty(district)) {
				query.append("and district like '%" + district + "%'");
			}
			if(!StringUtils.isNullOrEmpty(street)) {
				query.append("and ward like '%" + ward + "%'");
			}
			if(floorArea != null) {
				query.append("and floorarea like '%" + floorArea + "%'");
			}
			if(numberOfBasement != null) {
				query.append("and numberOfBasement like '%" + numberOfBasement +"%'");
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				System.out.print("ID: " + rs.getLong("id") + ", Type : " + rsmd.getColumnTypeName(1));
				System.out.print(", Name: " + rs.getString("name"));
				//System.out.print(", Street: " + rs.getString("street"));
				//System.out.print(", District: " + rs.getString("district"));
				//System.out.print(", Ward: " + rs.getString("ward"));
				String address = rs.getString("Street") + ", " + rs.getString("Ward") + ", " + rs.getString("District");
				System.out.print(", Address: " + address);
				System.out.println(", FloorArea " + rs.getInt("floorarea"));
				
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
		}*/
		
		
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
