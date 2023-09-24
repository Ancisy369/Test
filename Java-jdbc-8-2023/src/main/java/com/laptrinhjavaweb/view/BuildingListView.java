package com.laptrinhjavaweb.view;

import java.util.List;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		String name = null;
		String street = null;
		String ward = null;
		String district = null;
		Integer floorArea = null;

		BuildingSearchInput buildingSearch = new BuildingSearchInput();
		buildingSearch.setName(name);
		buildingSearch.setStreet(street);
		buildingSearch.setWard(ward);
		buildingSearch.setDistrict(district);
		buildingSearch.setFloorArea(floorArea);

		BuildingController buildingController = new BuildingController();
		List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);
		if (!buildings.isEmpty()) {
			for (BuildingOutput item : buildings) {
				System.out.print("Name: " + item.getName());
				System.out.print(" ,Address: " + (item.getAddress()));
				System.out.println(" ,Type : " + (item.getType()));
			}
		} else {
			System.out.println("Không tìm thấy tòa nhà phù hợp");
		}

	}
	
	

}
