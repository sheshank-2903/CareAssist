package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.ClaimsDTO;
import com.hexaware.careassist.entities.Claims;

public interface IClaimsService {
	public Claims addClaim(ClaimsDTO claimDto, long patientId, long planId);
	public Claims updateClaim(String newStatus, long claimId);
	public ClaimsDTO getClaimById(long claimId);
	public List<Claims> getAllClaims();
	public boolean deleteClaimById(Long claimId);
	public List<Claims> getClaimsByPatientId(long patientId);
	public List<Claims> getClaimsByStatus(String status);
	public List<Claims> getClaimsByPlanId(long planId);
	
}
