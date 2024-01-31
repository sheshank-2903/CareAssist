package com.hexaware.careassist.service;

import java.util.Set;

import com.hexaware.careassist.entities.Claims;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.entities.PolicyList;


public class InsauranceCompanyImp implements IInsuranceCompanyService {

	@Override
	public InsuranceCompany getInsuranceCompanyInfo(int cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInsuranceCompanyInfo(InsuranceCompany insuranceCompany) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInsuranceCompanyInfo(int cId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPolicy(PolicyList policyList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getAllPatientDetails(int policyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Claims> getClaimByPatientId(int InsauranceCompanyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeClaimStatus(int claimId) {
		// TODO Auto-generated method stub
		return false;
	}

}
