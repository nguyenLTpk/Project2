package com.javaweb.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	@Autowired
	
	private ModelMapper modelMapper;
	
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		DistrictEntity districtEntity = districtRepository.findNameById(item.getDistrictId());
		building.setAddress(item.getStreet() + ", " + item.getWard() + ", " + districtEntity.getName());
		List<RentAreaEntity> rentAreas = rentAreaRepository.getValueByBuildingId(item.getId());
		String areaResult = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		building.setRentArea(areaResult);
		return building;
	}
	
}
