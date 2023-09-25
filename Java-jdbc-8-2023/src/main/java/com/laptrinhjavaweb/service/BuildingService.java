package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.service.emyeuanh.BuildingEmyeuanh;

public interface BuildingService {
	List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel);
}
