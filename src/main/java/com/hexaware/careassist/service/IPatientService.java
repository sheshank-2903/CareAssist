package com.hexaware.careassist.service;

import java.util.Set;

import com.hexaware.careassist.entities.Claims;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.entities.PolicyList;


public interface IPatientService {
	public Patient getPatientInfo(int pid);
	public boolean updatePatientInfo(Patient patient);
	public boolean deletePatientInfo(int pid);
	public boolean requestClaim(int policyId,double claimAmount,String claimDescription,int insuranceCompanyId);
	public Set<Claims> getClaimList(int patientInt);
	public Set<PolicyList> getAllPolicyList(int patientId);
	public Set<Invoices> getAllInvoicesById(int paientId);
}
