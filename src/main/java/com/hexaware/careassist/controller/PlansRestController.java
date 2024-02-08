package com.hexaware.careassist.controller;

import java.util.List;

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
import com.hexaware.careassist.exceptions.NoSuchInsuranceCompanyFoundException;
import com.hexaware.careassist.exceptions.NoSuchPlanFoundException;
import com.hexaware.careassist.service.IPlansService;

@RestController
@RequestMapping("/api/plans")
public class PlansRestController {
	
	@Autowired
	IPlansService service;
	
	
	@PostMapping("/add")
	public Plans addPlan(@RequestBody PlansDTO plansDto,@PathVariable long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException {		
		return service.addPlan(plansDto, insuranceCompanyId);
	}
	
	
	@PutMapping("/update/{planName}/{description}/{coverageAmount}/{planId}")
	public Plans updatePlan(@PathVariable String planName,@PathVariable String description,@PathVariable double coverageAmount,@PathVariable long planId) throws NoSuchPlanFoundException {	
		return service.updatePlan(planName, description, coverageAmount, planId);
	}
	
	
	
	@DeleteMapping("/delete/{planId}")
	public String deletePlanById(@PathVariable long planId) throws NoSuchPlanFoundException {
		boolean isDeleted=service.deletePlanById(planId);
		return isDeleted?"Plan has been deleted":"Deletion unsuccessful";
		
	}
	
	
	
	@GetMapping("/getbyid/{planId}")
	public PlansDTO getPlanById(@PathVariable long planId) throws NoSuchPlanFoundException {
		return service.getPlanById(planId);
	}
	
	
	
	@GetMapping("/getall")
	public List<Plans> getAllPlans(){
		return service.getAllPlans();
	}
	
	
	
	@GetMapping("/getbyname/{planName}")
	public List<Plans> getPlanByName(@PathVariable String planName){
		return service.getPlanByName(planName);
	}
	
	
	
	@GetMapping("/getbyCompanyName/{companyName}")
	public List<Plans> getPlanByInsuranceCompanyName(@PathVariable String companyName) throws NoSuchInsuranceCompanyFoundException{
		return service.getPlanByInsuranceCompanyName(companyName);
	}

}
