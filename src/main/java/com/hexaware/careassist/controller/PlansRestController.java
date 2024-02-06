package com.hexaware.careassist.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.careassist.dto.PlansDTO;
import com.hexaware.careassist.entities.Plans;
import com.hexaware.careassist.service.IPlansService;

@RestController
@RequestMapping("/api/plans")
public class PlansRestController {
	
	@Autowired
	IPlansService service;
	
	Logger logger = LoggerFactory.getLogger(PlansRestController.class);
	
	
	@PostMapping("/add")
	public Plans addPlan(@RequestBody PlansDTO plansDto,@PathVariable long insuranceCompanyId) {
		logger.info("PlansRestController-- Plan with plan id: {} has been added successfully",plansDto.getPlanId());			
		return service.addPlan(plansDto, insuranceCompanyId);
	}
	
	
	@PutMapping("/update/{planName}/{coverageAmount}/{coverageAmount}/{planId}")
	public Plans updatePlan(@PathVariable String planName,@PathVariable String description,@PathVariable double coverageAmount,@PathVariable long planId) {//doubt how to pass multiple in requestbod
		logger.warn("PlansRestController-- Plan has been updated successfully");			
		return service.updatePlan(planName, description, coverageAmount, planId);
	}
	
	
	
	@DeleteMapping("/delete/{planId}")
	public String deletePlanById(@PathVariable long planId) {
		boolean isDeleted=service.deletePlanById(planId);
		logger.warn("PlansRestController-- Plan with id: {} has been deleted from the database!",planId);
		return isDeleted?"Plan has been deleted":"Deletion unsuccessful";
		
	}
	
	
	
	@GetMapping("/getbyid/{planId}")
	public PlansDTO getPlanById(@PathVariable long planId) {
		logger.info("PlansRestController-- Plan details fetched successfully");
		return service.getPlanById(planId);
	}
	
	
	
	@GetMapping("/getall")
	public List<Plans> getAllPlans(){
		logger.info("PlansRestController-- All Plan details fetched successfully");
		return service.getAllPlans();
	}
	
	
	
	@GetMapping("/getbyname/{planName}")
	public List<Plans> getPlanByName(@PathVariable String planName){
		logger.info("PlansRestController-- Plan details fetched successfully");
		return service.getPlanByName(planName);
	}
	
	
	
	@GetMapping("/getbyCompanyName/{companyName}")
	public List<Plans> getPlanByInsuranceCompanyName(@PathVariable String companyName){
		logger.info("Plan details fetched successfully");
		return service.getPlanByInsuranceCompanyName(companyName);
	}

}
