package com.hexaware.careassist.service;
import java.util.List;

import com.hexaware.careassist.dto.InsuranceCompanyDTO;
import com.hexaware.careassist.entities.InsuranceCompany;



public interface IInsuranceCompanyService {
	public InsuranceCompanyDTO getInsuranceCompanyById(int insuranceCompanyId);
	
	public boolean updateInsuranceCompany(InsuranceCompanyDTO insuranceCompanyDto);
	
	public boolean deleteInsuranceCompanyById(int insuranceCompanyId);
	
	public InsuranceCompanyDTO addInsuranceCompany(InsuranceCompanyDTO insuranceCompanyDto);
	
	public List<InsuranceCompany> getInsuranceCompanyByName(String insuranceCompanyName);
	
}
