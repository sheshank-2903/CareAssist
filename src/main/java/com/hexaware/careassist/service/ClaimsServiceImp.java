package com.hexaware.careassist.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.careassist.dto.ClaimsDTO;
import com.hexaware.careassist.entities.Claims;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.entities.Plans;
import com.hexaware.careassist.exceptions.NoSuchClaimFoundException;
import com.hexaware.careassist.repository.ClaimRepository;
import com.hexaware.careassist.repository.PatientRepository;
import com.hexaware.careassist.repository.PlansRepository;

import jakarta.transaction.Transactional;

@Service
public class ClaimsServiceImp implements IClaimsService {
	
	@Autowired
	ClaimRepository claimRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	PlansRepository planRepo;
	
	Logger logger =LoggerFactory.getLogger(ClaimsServiceImp.class);
	
	@Override
	public Claims addClaim(ClaimsDTO claimDto, long patientId, long planId) {
		
		Patient patient = patientRepo.findById(patientId).orElse(null);
		Plans plans = planRepo.findById(planId).orElse(null);
		Claims claims = claimRepo.save(new Claims(claimDto.getClaimId(),
											claimDto.getClaimAmount(),
											claimDto.getClaimStatus(),
											patient,
											plans
											));
		//check ki data jaa rh h ya nhi in ClaimS-Set of Patient Entity
		logger.info("ClaimsServiceImp - Claim added successfully");
		return claims;
	}

	@Transactional
	@Override
	public Claims updateClaim(String newStatus, long claimId) throws NoSuchClaimFoundException {
		Claims claim=claimRepo.findById(claimId).orElseThrow(()-> new NoSuchClaimFoundException("No such claim exists in database"));
		claimRepo.updateClaimStatus(newStatus,claimId);
		logger.info("ClaimsServiceImp - Claim status updated successfully");
		return claim;
	}

	@Override
	public ClaimsDTO getClaimById(long claimId)throws NoSuchClaimFoundException {
		Claims claim=claimRepo.findById(claimId).orElseThrow(()-> new NoSuchClaimFoundException("No such claim exists in database"));
		logger.info("ClaimsServiceImp - Claim data fetched successfully");
		return new ClaimsDTO(claim.getClaimId(),claim.getClaimAmount(),claim.getClaimStatus());
	}

	@Override
	public List<Claims> getAllClaims() {
		logger.info("ClaimsServiceImp - All Claims fetched successfully");
		return claimRepo.findAll();
	}

	@Override
	public boolean deleteClaimById(Long claimId) {
		claimRepo.deleteById(claimId);
		Claims claim=claimRepo.findById(claimId).orElse(null);
		logger.info("ClaimsServiceImp - Claim deleted successfully");
		//check ki data jaa rh h ya nhi in ClaimS-Set of Patient Entity
		return claim==null;
	}

	@Override
	public List<Claims> getClaimsByPatientId(long patientId) {
		List<Claims> claim=claimRepo.findBypatientId(patientId);
		logger.info("ClaimsServiceImp - All Claim by patientId fetched successfully");
		return claim;
	}

	@Override
	public List<Claims> getClaimsByStatus(String status) {
		List<Claims> claim=claimRepo.getClaimByStatus(status);
		logger.info("ClaimsServiceImp - All Claim by status fetched successfully");
		return claim;
	}

	@Override
	public List<Claims> getClaimsByPlanId(long planId) {
		List<Claims> claim=claimRepo.findByplanId(planId);
		logger.info("ClaimsServiceImp - All Claim by planId fetched successfully");
		return claim;
	}

}
