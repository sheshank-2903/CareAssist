package com.hexaware.careassist.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.careassist.dto.HealthCareProviderDTO;
import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.exceptions.NoSuchHealthCareProviderFoundException;

@SpringBootTest
class HealthCareProviderServiceImpTest {

	@Autowired
	IHealthCareProviderService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	//@Disabled
	void testAddHealthCareProvider() {
		HealthCareProvider response=service.addHealthCareProvider(new HealthCareProviderDTO(2,"sheshank","male","absc 123 sadbas","abc@gmail.com","asdkjf"));
		assertTrue(response.getHealthcareProviderName()=="sheshank" && response.getEmail()=="abc@gmail.com");
	}

	@Test
	@Disabled
	void testGetHealthCareProviderById() throws NoSuchHealthCareProviderFoundException {
		HealthCareProviderDTO response=service.getHealthCareProviderById(1);
		assertTrue(response.getHealthCareProviderId()==1);
	}

	@Test
	@Disabled
	void testUpdateHealthCareProviderInfo() throws NoSuchHealthCareProviderFoundException {
		HealthCareProvider response= service.updateHealthCareProvider(new HealthCareProviderDTO(
				1, "king",
				"male", "ashdhfiasd faisdhfisad fsaidufh",
				"bht@gmail.com", "asdkjksdfj"));
		assertTrue(response.getHealthcareProviderName()=="king");
	}

	@Test
	@Disabled
	void testDeleteHealthCareProviderInfo() {
		boolean response=service.deleteHealthCareProvider(2);
		assertTrue(response);
	}

	@Test
	@Disabled
	void testGetAllHealthCareProvider() {
		List<HealthCareProvider> response=service.getAllHealthCareProvider();
		assertTrue(response.size()==2);
	}

}
