package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.PlansDTO;
import com.hexaware.careassist.entities.Plans;

public interface IPlansService {
	public boolean addPlan(PlansDTO plansDto);
	public boolean updatePlan(PlansDTO plansDto);
	public boolean deletePlanById(PlansDTO plansDto);
	public PlansDTO getPlanById(int planId);
	public List<Plans> getAllPlans();
	public List<Plans> getPlanByName(String planName);
	public List<Plans> getPlanByinsuranceCompanyId(String insuranceCompanyId);
	
}
