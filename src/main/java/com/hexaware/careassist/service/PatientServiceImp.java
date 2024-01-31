package com.hexaware.careassist.service;

import java.util.Set;

public class PatientServiceImp implements IPatientService {

	@Override
	public com.hexaware.careassist.entities.Patient getPatientInfo(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePatientInfo(com.hexaware.careassist.entities.Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatientInfo(int pid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestClaim(int policyId, double claimAmount, String claimDescription, int insuranceCompanyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<com.hexaware.careassist.entities.Claims> getClaimList(int patientInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<com.hexaware.careassist.entities.PolicyList> getAllPolicyList(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<com.hexaware.careassist.entities.Invoices> getAllInvoicesById(int paientId) {
		// TODO Auto-generated method stub
		return null;
	}


}
