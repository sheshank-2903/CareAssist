package com.hexaware.careassist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.hexaware.careassist.exceptions.NoSuchClaimFoundException;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;
import com.hexaware.careassist.exceptions.NoSuchPlanFoundException;
import com.hexaware.careassist.service.IClaimsService;

@RestController
@RequestMapping("/api/v1/claims")
public class ClaimsRestController {
	
	@Autowired
	IClaimsService claimService;

	
	
	@PostMapping("/add/{patientId}/{planId}")
	@PreAuthorize("hasAuthority('PATIENT')")
	public Claims addClaim(@RequestBody ClaimsDTO claimDto,@PathVariable long patientId,@PathVariable long planId) throws NoSuchPatientFoundException, NoSuchPlanFoundException {
		return claimService.addClaim(claimDto, patientId, planId);
	}
	
	@PutMapping("/update/claimId")
	@PreAuthorize("hasAuthority('INSURANCE_COMPANY')")
	public Claims updateClaim(@RequestBody String newStatus,@PathVariable long claimId) throws NoSuchClaimFoundException {
		return claimService.updateClaim(newStatus, claimId);
	}
	
	@GetMapping("/get/{claimId}")
	@PreAuthorize("hasAuthority('PATIENT') || hasAuthority('ADMIN')")
	public ClaimsDTO getClaimById(@PathVariable long claimId) throws NoSuchClaimFoundException {
		return claimService.getClaimById(claimId);
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Claims> getAllClaims() {
		return claimService.getAllClaims();
	}
	
	@DeleteMapping("/delete/{claimId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public boolean deleteClaimById(@PathVariable long claimId) throws NoSuchClaimFoundException {
		return claimService.deleteClaimById(claimId);
	}
	
	@GetMapping("/getbypatientid/{patientId}")
	@PreAuthorize("hasAuthority('PATIENT') || hasAuthority('ADMIN')")
	public List<Claims> getClaimsByPatientId(@PathVariable long patientId) {
		return claimService.getClaimsByPatientId(patientId);
	}
	
	@GetMapping("/getbystatus/{status}/{patientId}")
	@PreAuthorize("hasAuthority('INSURANCE_COMPANY') || hasAuthority('PATIENT')")
	public List<Claims> getClaimsByStatus(@PathVariable String status,@PathVariable long patientId) {
		return claimService.getClaimsByStatus(status,patientId);
	}
	
	@GetMapping("/getbyplanId/{planId}")
	@PreAuthorize("hasAuthority('INSURANCE_COMPANY')")
	public List<Claims> getClaimsByPlanId(@PathVariable long planId) {
		return claimService.getClaimsByPlanId(planId);
	}
	
	
	
}
