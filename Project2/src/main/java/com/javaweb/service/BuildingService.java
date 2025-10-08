package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingService {
	List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode);
}
