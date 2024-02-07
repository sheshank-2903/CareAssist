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

import com.hexaware.careassist.dto.ClaimsDTO;
import com.hexaware.careassist.entities.Claims;
import com.hexaware.careassist.service.IClaimsService;

@RestController
@RequestMapping("/api/claims")
public class ClaimsRestController {
	
	@Autowired
	IClaimsService claimService;
	
	@PostMapping("/add/{patientId}/{planId}")
	public Claims addClaim(@RequestBody ClaimsDTO claimDto,@PathVariable long patientId,@PathVariable long planId) {
		return claimService.addClaim(claimDto, patientId, planId);
	}
	
	@PutMapping("/update/claimId")
	public Claims updateClaim(@RequestBody String newStatus,@PathVariable long claimId) {
		return claimService.updateClaim(newStatus, claimId);
	}
	
	@GetMapping("/get/{claimId}")
	public ClaimsDTO getClaimById(@PathVariable long claimId) {
		return claimService.getClaimById(claimId);
	}
	
	@GetMapping("/getall")
	public List<Claims> getAllClaims() {
		return claimService.getAllClaims();
	}
	
	@DeleteMapping("/delete/{claimId}")
	public boolean deleteClaimById(@PathVariable long claimId) {
		return claimService.deleteClaimById(claimId);
	}
	
	@GetMapping("/getbypatientid/{patientId}")
	public List<Claims> getClaimsByPatientId(@PathVariable long patientId) {
		return claimService.getClaimsByPatientId(patientId);
	}
	
	@GetMapping("/getbystatus/{status}")
	public List<Claims> getClaimsByStatus(@PathVariable String status) {
		return claimService.getClaimsByStatus(status);
	}
	
	@GetMapping("/getbyplanId/{planId}")
	public List<Claims> getClaimsByPlanId(@PathVariable long planId) {
		return claimService.getClaimsByPlanId(planId);
	}
}
