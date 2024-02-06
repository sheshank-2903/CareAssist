package com.hexaware.careassist.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.careassist.dto.InsuranceCompanyDTO;
import com.hexaware.careassist.entities.InsuranceCompany;

@SpringBootTest
class InsuranceCompanyImpTest {
	
	@Autowired
	IInsuranceCompanyService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testGetInsuranceCompanyById() {
		InsuranceCompanyDTO response=service.getInsuranceCompanyById(1);
		assertTrue(response.getInsuranceCompanyId()==1);
	}

	@Test
	@Disabled
	void testUpdateInsuranceCompany() {
		InsuranceCompany response= service.updateInsuranceCompany(new InsuranceCompanyDTO((long)1,"askdjf  ","abas","6367016451","abc@gmail.com"));
		assertTrue(response.getCompanyName()=="abas");
	}

	@Test
	@Disabled
	void testDeleteInsuranceCompanyById() {
		boolean response=service.deleteInsuranceCompanyById(1);
		assertTrue(response);
	}

	@Test
//	@Disabled
	void testAddInsuranceCompany() {
		InsuranceCompany response=service.addInsuranceCompany(new InsuranceCompanyDTO((long)5,"description","name","6367016451","abc@gmail.com"));
		assertTrue(response.getCompanyName()=="name" && response.getInsuranceCompanyDescription()=="description");
	}

	@Test
	@Disabled
	void testGetInsuranceCompanyByName() {
		List<InsuranceCompany> response=service.getInsuranceCompanyByName("name2");
		assertTrue(response.size()==1);
		
	}

}
