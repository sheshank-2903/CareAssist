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

import com.hexaware.careassist.dto.ClaimsDTO;
import com.hexaware.careassist.entities.Claims;
import com.hexaware.careassist.service.IClaimsService;

@RestController
@RequestMapping("/api/claims")
public class ClaimsRestController {
	
	@Autowired
	IClaimsService claimService;
	
	Logger logger = LoggerFactory.getLogger(ClaimsRestController.class);
	
	@PostMapping("/add")
	public Claims addClaim(@RequestBody ClaimsDTO claimDto,@RequestBody long patientId,@RequestBody long planId) {
		logger.info("ClaimsRestController -- claim added successfully ");
		return claimService.addClaim(claimDto, patientId, planId);
	}
	
	@PutMapping("/update")
	public Claims updateClaim(@RequestBody String newStatus,@RequestBody long claimId) {
		logger.info("ClaimsRestController -- claim status updates successfully ");
		return claimService.updateClaim(newStatus, claimId);
	}
	
	@GetMapping("/get/{claimId}")
	public ClaimsDTO getClaimById(@PathVariable long claimId) {
		logger.info("ClaimsRestController -- claim data by id fetched successfully");
		return claimService.getClaimById(claimId);
	}
	
	@GetMapping("/getall")
	public List<Claims> getAllClaims() {
		logger.info("ClaimsRestController -- claim data fetched successfully ");
		return claimService.getAllClaims();
	}
	
	@DeleteMapping("/delete/{claimId}")
	public boolean deleteClaimById(@PathVariable long claimId) {
		logger.info("ClaimsRestController -- claim deleted successfully ");
		return claimService.deleteClaimById(claimId);
	}
	
	@GetMapping("/getbypatientid/{patientId}")
	public List<Claims> getClaimsByPatientId(@PathVariable long patientId) {
		logger.info("ClaimsRestController -- claim  by patient Id data fetched successfully ");
		return claimService.getClaimsByPatientId(patientId);
	}
	
	@GetMapping("/getbystatus/{status}")
	public List<Claims> getClaimsByStatus(@PathVariable String status) {
		logger.info("ClaimsRestController -- claim  by status data fetched successfully ");
		return claimService.getClaimsByStatus(status);
	}
	
	@GetMapping("/getbyplanId/{planId}")
	public List<Claims> getClaimsByPlanId(@PathVariable long planId) {
		logger.info("ClaimsRestController -- claim  by planId data fetched successfully ");
		return claimService.getClaimsByPlanId(planId);
	}
}
