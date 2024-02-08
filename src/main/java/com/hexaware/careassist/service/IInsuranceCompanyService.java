package com.hexaware.careassist.service;
import java.util.List;

import com.hexaware.careassist.dto.InsuranceCompanyDTO;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.exceptions.NoSuchInsuranceCompanyFoundException;



public interface IInsuranceCompanyService {
	public InsuranceCompanyDTO getInsuranceCompanyById(long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException;
	
	public InsuranceCompany updateInsuranceCompany(InsuranceCompanyDTO insuranceCompanyDto) throws NoSuchInsuranceCompanyFoundException;
	
	public boolean deleteInsuranceCompanyById(long insuranceCompanyId);
	
	public InsuranceCompany addInsuranceCompany(InsuranceCompanyDTO insuranceCompanyDto);
	
	public List<InsuranceCompany> getInsuranceCompanyByName(String insuranceCompanyName);
	
}
