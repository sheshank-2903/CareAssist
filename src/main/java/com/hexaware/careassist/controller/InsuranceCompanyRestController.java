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
import com.hexaware.careassist.dto.InsuranceCompanyDTO;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.service.IInsuranceCompanyService;

@RestController
@RequestMapping("/api/insurancecompany")
public class InsuranceCompanyRestController {
	
	@Autowired
	IInsuranceCompanyService insauranceCompanyService; 
	Logger logger =LoggerFactory.getLogger(InsuranceCompanyRestController.class);
	
	@GetMapping("/get/{insuranceCompanyId}")
	public InsuranceCompanyDTO getInsuranceCompanyById(@PathVariable long insuranceCompanyId) {
		logger.info("InsuranceCompanyRestController - InsuranceCompany data by Id fetched successfully");
		return insauranceCompanyService.getInsuranceCompanyById(insuranceCompanyId);
	}
	
	@PutMapping("/update")
	public InsuranceCompany updateInsuranceCompany(@RequestBody InsuranceCompanyDTO insuranceCompanyDto) {
		logger.info("InsuranceCompanyRestController - InsuranceCompany updated successfully");
		return insauranceCompanyService.updateInsuranceCompany(insuranceCompanyDto);
	}

	@DeleteMapping("/delete/{insuranceCompanyId}")
	public boolean deleteInsuranceCompanyById(@PathVariable long insuranceCompanyId) {
		logger.info("InsuranceCompanyRestController - InsuranceCompany deleted successfully");
		return insauranceCompanyService.deleteInsuranceCompanyById(insuranceCompanyId);
	}
	
	@PostMapping("/add")
	public InsuranceCompany addInsuranceCompany(@RequestBody InsuranceCompanyDTO insuranceCompanyDto) {
		logger.info("InsuranceCompanyRestController - InsuranceCompany added successfully");
		return insauranceCompanyService.addInsuranceCompany(insuranceCompanyDto);
	}
	
	@GetMapping("/getbyname/{insuranceCompanyName}")
	public List<InsuranceCompany> getInsuranceCompanyByName(@PathVariable String insuranceCompanyName) {
		logger.info("InsuranceCompanyImp - InsuranceCompany data by name fetched successfully");
		return insauranceCompanyService.getInsuranceCompanyByName(insuranceCompanyName);
	}
}
