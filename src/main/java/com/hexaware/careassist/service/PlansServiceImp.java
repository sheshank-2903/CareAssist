package com.hexaware.careassist.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.careassist.dto.PlansDTO;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.entities.Plans;
import com.hexaware.careassist.exceptions.NoSuchInsuranceCompanyFoundException;
import com.hexaware.careassist.exceptions.NoSuchPlanFoundException;
import com.hexaware.careassist.repository.InsuranceCompanyRepository;
import com.hexaware.careassist.repository.PlansRepository;

import jakarta.transaction.Transactional;

@Service
public class PlansServiceImp implements IPlansService {

	@Autowired
	PlansRepository repo;
	
	@Autowired
	InsuranceCompanyRepository insuranceCompanyRepo;
	
	Logger logger =LoggerFactory.getLogger(PlansServiceImp.class);
	
	@Override
	public Plans addPlan(PlansDTO plansDto,long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException {
		
		InsuranceCompany insuranceCompany=insuranceCompanyRepo.findById(insuranceCompanyId).orElseThrow(()-> new NoSuchInsuranceCompanyFoundException("No such Insurance Company exists in database"));
		
		Plans plans=new Plans();
		plans.setPlanId(plansDto.getPlanId());
		plans.setPlanName(plansDto.getPlanName());
		plans.setCoverageAmount(plansDto.getCoverageAmount());
		plans.setDateOfIssue(plansDto.getDateOfIssue());
		plans.setDescription(plansDto.getDescription());
		plans.setInsuranceCompany(insuranceCompany);	
		
		logger.info("PlansServiceImp-- Plan with plan id: {} has been added successfully",plans.getPlanId());			
			
		return repo.save(plans);
	}

	@Transactional
	@Override
	public Plans updatePlan(String planName,String description,double coverageAmount,long planId) throws NoSuchPlanFoundException {

		Plans plans=repo.findById(planId).orElseThrow(()-> new NoSuchPlanFoundException("No such Plan exists in database"));
		plans.setPlanName(planName);
		plans.setDescription(description);
		plans.setCoverageAmount(coverageAmount);
		plans.setPlanId(planId);
		Plans plan=repo.save(plans);
		logger.warn("PlansServiceImp-- Plan with plan id: {} has been updated successfully",plan.getPlanId());			
		return plan;
	}

	@Override
	public boolean deletePlanById(long planId) throws NoSuchPlanFoundException {
		repo.findById(planId).orElseThrow(()-> new NoSuchPlanFoundException("No such Plan exists in database"));
		
		repo.deleteById(planId);
		Plans plans=repo.findById(planId).orElse(null);
		
		boolean bool=false;
		if(plans==null) {
			bool=true;
			logger.warn("PlansServiceImp-- Plan with id: {} has been deleted from the database!",planId);
		}
		return bool;
	}

	@Override
	public PlansDTO getPlanById(long planId) throws NoSuchPlanFoundException {

		Plans plans=repo.findById(planId).orElseThrow(()-> new NoSuchPlanFoundException("No such Plan exists in database"));
		
		PlansDTO plansDto=new PlansDTO();
		plansDto.setPlanId(plans.getPlanId());
		plansDto.setPlanName(plans.getPlanName());
		plansDto.setCoverageAmount(plans.getCoverageAmount());
		plansDto.setDateOfIssue(plans.getDateOfIssue());
		plansDto.setDescription(plans.getDescription());
		
		logger.info("PlansServiceImp-- Plan details with  id:{}  fetched successfully",planId);
		return plansDto;
	}

	@Override
	public List<Plans> getAllPlans() {
		logger.info("PlansServiceImp-- All Plan details fetched successfully");
		return repo.findAll();
	}

	@Override
	public List<Plans> getPlanByName(String planName) {
		logger.info("PlansServiceImp-- Plan details with  name:{}  fetched successfully",planName);
		return repo.findByPlanName(planName);
	}

	@Override
	public List<Plans> getPlanByInsuranceCompanyName(String companyName) throws NoSuchInsuranceCompanyFoundException {
		insuranceCompanyRepo.findByCompanyName(companyName).orElseThrow(()-> new NoSuchInsuranceCompanyFoundException("No such Insurance Company exists in database"));
		logger.info("PlansServiceImp-- Plan details with company name:{}  fetched successfully",companyName);
		return repo.findByCompanyName(companyName);
	}


}
