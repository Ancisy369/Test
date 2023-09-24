package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dao.BuildingDao;
import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;

public class BuildingDaoImpl implements BuildingDao {

	@Override
	public List<BuildingAnhyeuem> findBuilding(Integer floorArea, String name, String ward, String street,
			String district) {
		// TODO Auto-generated method stub
		// BuildingAnhyeuem[] results = new BuildingAnhyeuem[3];
		List<BuildingAnhyeuem> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			StringBuilder query = new StringBuilder("SELECT * FROM building" + SystemConstant.ONE_EQUAL_ONE);
			if (!StringUtils.isNullOrEmpty(name)) {
//				query.append("and name like '%"+ name + "%'");
				query.append("and name like '%" + name + "%'");
			}
			if (!StringUtils.isNullOrEmpty(street)) {
				query.append("and street like '%" + street + "%'");
			}
			if (!StringUtils.isNullOrEmpty(district)) {
				query.append("and district like '%" + district + "%'");
			}
			if (!StringUtils.isNullOrEmpty(ward)) {
				query.append("and ward like '%" + ward + "%'");
			}
			if (floorArea != null) {
				query.append("and floorarea = " + floorArea + "");
			}
			/*
			 * if(numberOfBasement != null) { query.append("and numberOfBasement like '%" +
			 * numberOfBasement +"%'"); }
			 */

			Class.forName("com.mysql.jdbc.Driver");
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			// int i =0;
			
			while (rs.next()) {
				BuildingAnhyeuem buildingAnhyeuem = new BuildingAnhyeuem();
				buildingAnhyeuem.setName(rs.getString("name"));
				buildingAnhyeuem.setStreet(rs.getString("street"));
				buildingAnhyeuem.setWard(rs.getString("ward"));
				buildingAnhyeuem.setDistrict(rs.getString("district"));
				buildingAnhyeuem.setFloorArea(rs.getInt("floorArea"));
				buildingAnhyeuem.setType(rs.getString("type"));
				results.add(buildingAnhyeuem);
			}
			return results;
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
		return new ArrayList<>();
	}

}
