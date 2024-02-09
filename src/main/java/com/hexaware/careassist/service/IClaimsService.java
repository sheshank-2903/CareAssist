package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.ClaimsDTO;
import com.hexaware.careassist.entities.Claims;
import com.hexaware.careassist.exceptions.NoSuchClaimFoundException;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;
import com.hexaware.careassist.exceptions.NoSuchPlanFoundException;

public interface IClaimsService {
	public Claims addClaim(ClaimsDTO claimDto, long patientId, long planId) throws NoSuchPatientFoundException, NoSuchPlanFoundException;
	public Claims updateClaim(String newStatus, long claimId) throws NoSuchClaimFoundException;
	public ClaimsDTO getClaimById(long claimId) throws NoSuchClaimFoundException;
	public List<Claims> getAllClaims();
	public boolean deleteClaimById(Long claimId) throws NoSuchClaimFoundException;
	public List<Claims> getClaimsByPatientId(long patientId);
	public List<Claims> getClaimsByStatus(String status,Long patientId);
	public List<Claims> getClaimsByPlanId(long planId);
	
}
