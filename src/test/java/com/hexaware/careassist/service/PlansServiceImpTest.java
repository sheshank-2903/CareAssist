package com.hexaware.careassist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.careassist.dto.PlansDTO;
import com.hexaware.careassist.entities.Plans;

@SpringBootTest
class PlansServiceImpTest {

	@Autowired
	IPlansService service;
	
	@Test
	@Disabled
	void testAddPlan() {
		PlansDTO plansDto=new PlansDTO(2,"aaaa","aaaaa",LocalDate.now(),60000);
		Plans plan=service.addPlan(plansDto, 2);
		assertEquals(2,plan.getPlanId());	
	}

	@Test
	@Disabled
	void testUpdatePlan() {
		//PlansDTO plansDto=new PlansDTO(1,"bbbb","aaaaa",LocalDate.now(),65000);
		Plans plan=service.updatePlan("tut","djsdjsdjs",60000,3);
		assertEquals(60000.0,plan.getCoverageAmount());
	}

	@Test
	@Disabled
	void testDeletePlanById() {
		boolean bool=service.deletePlanById(2);
		assertTrue(bool);
	}

	@Test
	@Disabled
	void testGetPlanById() {
		PlansDTO plan=service.getPlanById(2);
		assertEquals(2,plan.getPlanId());
	}

	@Test
	@Disabled
	void testGetAllPlans() {
		List<Plans> list=service.getAllPlans();
		assertTrue(list.size()==2);
	}

	@Test
	@Disabled
	void testGetPlanByName() {
		List<Plans> list=service.getPlanByName("aaaa");  //name se multiple plans??
		assertTrue(list.size()==1);
	}

	@Test
	@Disabled
	void testGetPlanByInsuranceCompanyName() {
		List<Plans> list=service.getPlanByInsuranceCompanyName("abas");
		assertTrue(list.size()==1);
	}

}
