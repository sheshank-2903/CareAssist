package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.PlansDTO;
import com.hexaware.careassist.entities.Plans;

public interface IPlansService {
	public Plans addPlan(PlansDTO plansDto,long insuranceCompanyId);
	public Plans updatePlan(String planName,String description,double coverageAmount,long planId);
	public boolean deletePlanById(long planId);
	public PlansDTO getPlanById(long planId);
	public List<Plans> getAllPlans();
	public List<Plans> getPlanByName(String planName);
	public List<Plans> getPlanByInsuranceCompanyName(String companyName);
	
}
