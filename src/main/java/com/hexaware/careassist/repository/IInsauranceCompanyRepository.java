package com.hexaware.careassist.repository;

import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.entities.PolicyList;

public interface IInsauranceCompanyRepository {
	public InsuranceCompany getInsuranceCompanyInfo(int cId);
	public boolean updateInsuranceCompanyInfo(InsuranceCompany insuranceCompany);
	public boolean deleteInsuranceCompanyInfo(int cId);
	public boolean addPolicy(PolicyList policyList);
	public Patient getAllPatientDetails(int policyId);
}
