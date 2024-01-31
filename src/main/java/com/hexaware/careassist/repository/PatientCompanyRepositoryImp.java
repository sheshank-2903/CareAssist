package com.hexaware.careassist.repository;

import java.util.Set;

import com.hexaware.careassist.entities.Claims;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.entities.PolicyList;

public class PatientCompanyRepositoryImp implements IPatientRepository {

	@Override
	public Patient getPatientInfo(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePatientInfo(Patient patient) {
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
	public Set<Claims> getClaimList(int patientInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PolicyList> getAllPolicyList(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Invoices> getAllInvoicesById(int paientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
