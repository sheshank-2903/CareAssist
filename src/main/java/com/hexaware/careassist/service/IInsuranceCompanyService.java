package com.hexaware.careassist.service;

import java.util.Set;

import com.hexaware.careassist.entities.Claims;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.entities.PolicyList;


public interface IInsuranceCompanyService {
	public InsuranceCompany getInsuranceCompanyInfo(int cId);
	public boolean updateInsuranceCompanyInfo(InsuranceCompany insuranceCompany);
	public boolean deleteInsuranceCompanyInfo(int cId);
	public boolean addPolicy(PolicyList policyList);
	public Patient getAllPatientDetails(int policyId);
	public Set<Claims> getClaimByPatientId(int InsauranceCompanyId);
	public boolean changeClaimStatus(int claimId);
	
}
