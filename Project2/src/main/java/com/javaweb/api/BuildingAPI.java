package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customeException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;


@RestController
// @RequestMapping("/api/building")
public class BuildingAPI {

//    @PostMapping
//    public Object getBuildings(@RequestBody BuildingDTO building) {
//    
//        // Giả lập xử lý dưới DB xong rồi
//    	try {
//    		validate(building);
//    	}
//    	catch(Exception e) {
//    		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//    		errorResponseDTO.setError(e.getMessage());
//    		List<String> details = new ArrayList<>();
//    		details.add("Kiểm tra lại name hoặc numberofbasement");
//    		errorResponseDTO.setDetail(details);
//    		return errorResponseDTO;
//    	}
//    	
//    	return null;
//    }
//
//    
//    public void validate(BuildingDTO buildingDTO) throws FieldRequiredException{
//    	if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumberOfBasement() == null) {
//    		throw new FieldRequiredException("name or numberofbasement is null");
//    	}
//    }
//    
     @Autowired
     private BuildingService buildingService;
     
     @GetMapping(value="/api/building/")
     public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
    		                              @RequestParam(required = false) List<String> typceCode){
    	 List<BuildingDTO> result = buildingService.findAll(params, typceCode);
    	 return result;
     }
}