package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.ClaimsDTO;
import com.hexaware.careassist.entities.Claims;

public interface IClaimsService {
	public boolean addClaim(ClaimsDTO claimDto, long patientId, long planId);
	public boolean updateclaim(ClaimsDTO claimDto);
	public ClaimsDTO getClaimById(long claimId);
	public List<Claims> getAllClaims();
	public boolean deleteClaimById();
	public List<Claims> getClaimsByPatientId(long patientId);
	public List<Claims> getClaimsByStatus(String status);
	public List<Claims> getClaimsByPlanId(long planId);
	
}
