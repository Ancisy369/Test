package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.BuildingDao;
import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.dao.impl.BuildingDaoImpl;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.emyeuanh.BuildingEmyeuanh;

public class BuildingServiceImpl implements BuildingService {

	private BuildingDao buildingDao = new BuildingDaoImpl();

	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel) {
		List<BuildingOutput> buildingEmyeuanhs = new ArrayList<>();
		List<BuildingAnhyeuem> anhyeuems = buildingDao.findBuilding(buildingModel.getFloorArea(),
				buildingModel.getName(), buildingModel.getWard(), buildingModel.getStreet(),
				buildingModel.getDistrict());
		// int i = 0;
		for (BuildingAnhyeuem item : anhyeuems) {
			BuildingOutput buildingOutput = new BuildingOutput();
			buildingOutput.setName(item.getName());
			buildingOutput.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict()
					+ " - FloorArea : " + item.getFloorArea());
			buildingOutput.setType(convertInputString(item.getType()));
			/*
			 * buildingEmyeuanhs[i] = buildingEmyeuanh; i++;
			 */
			buildingEmyeuanhs.add(buildingOutput);
		}
		return buildingEmyeuanhs;
	}
	
	
	//convert Type tang_tret -> tầng trệt, nguyen_can -> nguyên căn
		public String convertInputString(String input) {
			StringBuilder resultBuilder = new StringBuilder();
			String[] parts;
			String result = null;
			if (input != null) {
				//b1-tách làm mảng chuỗi
				parts = input.split(",");
				
				//b2-đổi type thành chuỗi có dấu
				for (int i = 0; i < parts.length; i++) {
					String part = parts[i];
					String convertedPart = convertString(part);
					if (convertedPart.equals("tang tret")) {
						convertedPart = "tầng trệt";
					} else if (convertedPart.equals("nguyen can")) {
						convertedPart = "nguyên căn";
					}
					resultBuilder.append(convertedPart);

					if (i < parts.length - 1) {
						resultBuilder.append(", ");
					}
					result = resultBuilder.toString();
				}
			}
			return result; // tầng trệt, nguyên căn
		}

		// Chuyển đổi chuỗi bằng cách thay thế dấu gạch dưới (_) bằng dấu cách (" ")
		public String convertString(String input) {
			
			return input.replaceAll("_", " ");
		}
	
	
}
