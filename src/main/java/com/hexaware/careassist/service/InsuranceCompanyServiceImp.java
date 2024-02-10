package com.hexaware.careassist.service;

import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.careassist.dto.InsuranceCompanyDTO;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchInsuranceCompanyFoundException;
import com.hexaware.careassist.repository.InsuranceCompanyRepository;
import com.hexaware.careassist.repository.PlansRepository;

@Service
public class InsuranceCompanyServiceImp implements IInsuranceCompanyService {
	
	@Autowired
	InsuranceCompanyRepository insuranceCompanyRepo;
	
	@Autowired
	PlansRepository plansRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	Logger logger =LoggerFactory.getLogger(InsuranceCompanyServiceImp.class);

	@Override
	public InsuranceCompanyDTO getInsuranceCompanyById(long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException {
		InsuranceCompany insuranceCompany = insuranceCompanyRepo.findById(insuranceCompanyId).orElseThrow(() -> new NoSuchInsuranceCompanyFoundException("No such Insurance Company exists in database"));
		logger.info("InsuranceCompanyImp - InsuranceCompany data by Id fetched successfully");
		return new InsuranceCompanyDTO(insuranceCompany.getInsuranceCompanyId(),
										insuranceCompany.getInsuranceCompanyDescription(),
										insuranceCompany.getCompanyName(),
										insuranceCompany.getCompanyContactNumber(),
										insuranceCompany.getEmail(),
										insuranceCompany.getPassword());
	}

	@Override
	public InsuranceCompany updateInsuranceCompany(InsuranceCompanyDTO insuranceCompanyDto) throws NoSuchInsuranceCompanyFoundException {
		insuranceCompanyRepo.findById(insuranceCompanyDto.getInsuranceCompanyId()).orElseThrow(() -> new NoSuchInsuranceCompanyFoundException("No such Insurance Company exists in database"));
		
		insuranceCompanyDto.setPassword(passwordEncoder.encode(insuranceCompanyDto.getPassword()));
		
		InsuranceCompany insuranceCompany = insuranceCompanyRepo.save(new InsuranceCompany(
																		insuranceCompanyDto.getInsuranceCompanyId(),
																		insuranceCompanyDto.getInsuranceCompanyDescription(),
																		insuranceCompanyDto.getCompanyName(),
																		insuranceCompanyDto.getCompanyContactNumber(),
																		insuranceCompanyDto.getEmail(),
																		insuranceCompanyDto.getPassword(),
																		new HashSet<>()));
		
		
		
		logger.info("InsuranceCompanyImp - InsuranceCompany updated successfully");
		return insuranceCompany;
	}

	@Override
	public boolean deleteInsuranceCompanyById(long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException {
		
		insuranceCompanyRepo.findById(insuranceCompanyId).orElseThrow(() -> new NoSuchInsuranceCompanyFoundException("No such Insurance Company exists in database"));
		insuranceCompanyRepo.deleteById(insuranceCompanyId);
		InsuranceCompany insuranceCompany = insuranceCompanyRepo.findById(insuranceCompanyId).orElse(null);
		logger.info("InsuranceCompanyImp - InsuranceCompany deleted successfully");
		return insuranceCompany==null;
	}

	@Override
	public InsuranceCompany addInsuranceCompany(InsuranceCompanyDTO insuranceCompanyDto) throws EmailAlreadyPresentException {
		if(insuranceCompanyRepo.findByEmail(insuranceCompanyDto.getEmail()).orElse(null)!=null) {
			throw new EmailAlreadyPresentException("This email is already present in database");
		}
		insuranceCompanyDto.setPassword(passwordEncoder.encode(insuranceCompanyDto.getPassword()));
		InsuranceCompany insuranceCompany = insuranceCompanyRepo.save(new InsuranceCompany(insuranceCompanyDto.getInsuranceCompanyId(),
														insuranceCompanyDto.getInsuranceCompanyDescription(),
														insuranceCompanyDto.getCompanyName(),
														insuranceCompanyDto.getCompanyContactNumber(),
														insuranceCompanyDto.getEmail(),
														insuranceCompanyDto.getPassword(),
														new HashSet<>()));
		logger.info("InsuranceCompanyImp - InsuranceCompany added successfully");
		return insuranceCompany;
	}

	@Override
	public InsuranceCompany getInsuranceCompanyByName(String insuranceCompanyName) throws NoSuchInsuranceCompanyFoundException {
		logger.info("InsuranceCompanyImp - InsuranceCompany data by name fetched successfully");
		return insuranceCompanyRepo.findByCompanyName(insuranceCompanyName).orElseThrow(() -> new NoSuchInsuranceCompanyFoundException("No such Insurance Company exists in database"));
	}
	
	@Override
	public List<InsuranceCompany> getAllInsuranceCompany() {
		logger.info("InsuranceCompanyImp - All InsuranceCompany data fetched successfully");
		return insuranceCompanyRepo.findAll();
	}


}
