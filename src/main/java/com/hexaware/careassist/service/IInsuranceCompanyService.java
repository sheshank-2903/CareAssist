package com.hexaware.careassist.service;
import java.util.List;

import com.hexaware.careassist.dto.InsuranceCompanyDTO;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchInsuranceCompanyFoundException;



public interface IInsuranceCompanyService {
	public InsuranceCompanyDTO getInsuranceCompanyById(long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException;
	
	public InsuranceCompany updateInsuranceCompany(InsuranceCompanyDTO insuranceCompanyDto) throws NoSuchInsuranceCompanyFoundException;
	
	public boolean deleteInsuranceCompanyById(long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException;
	
	public InsuranceCompany addInsuranceCompany(InsuranceCompanyDTO insuranceCompanyDto) throws EmailAlreadyPresentException;
	
	public InsuranceCompany getInsuranceCompanyByName(String insuranceCompanyName) throws NoSuchInsuranceCompanyFoundException;

	List<InsuranceCompany> getAllInsuranceCompany();
	
}
