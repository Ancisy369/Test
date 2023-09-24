package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.emyeuanh.BuildingEmyeuanh;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImpl();
			
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch) {
		List<BuildingOutput> results = buildingService.findBuilding(buildingSearch);
		/*List<BuildingEmyeuanh> buildingEmyeuanhs = buildingService.findBuilding(buildingSearch);
		
		for(BuildingEmyeuanh item:buildingEmyeuanhs) {
			BuildingOutput buildingModel = new BuildingOutput();
			buildingModel.setName(item.getName());
			results.add(buildingModel);
		}*/
		return results;
	}
	

	

}
