package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.ClaimsDTO;
import com.hexaware.careassist.entities.Claims;

public class ClaimsServiceImp implements IClaimsService {

	@Override
	public boolean addClaim(ClaimsDTO claimDto, long patientId, long planId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateclaim(ClaimsDTO claimDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClaimsDTO getClaimById(long claimId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claims> getAllClaims() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteClaimById() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Claims> getClaimsByPatientId(long patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claims> getClaimsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claims> getClaimsByPlanId(long planId) {
		// TODO Auto-generated method stub
		return null;
	}

}
