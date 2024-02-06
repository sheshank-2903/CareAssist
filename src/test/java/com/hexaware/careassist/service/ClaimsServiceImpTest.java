package com.hexaware.careassist.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.careassist.dto.ClaimsDTO;
import com.hexaware.careassist.entities.Claims;

@SpringBootTest
class ClaimsServiceImpTest {
	
	@Autowired
	IClaimsService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testAddClaim() {
		Claims claims = service.addClaim(new ClaimsDTO(2,1000.00,"askjb"), 1, 1);
		assertTrue(claims.getClaimStatus()=="pending" && claims.getClaimAmount()==1000.00);
	}

	@Test
	@Disabled
	void testUpdateclaim() {
		Claims claims = service.updateClaim("pending",1);
		assertEquals("pending",claims.getClaimStatus());
	}

	@Test
	@Disabled
	void testGetClaimById() {
		ClaimsDTO claim=service.getClaimById(1);
		assertEquals("pending",claim.getClaimStatus());
	}

	@Test
	@Disabled
	void testGetAllClaims() {
		List<Claims> response = service.getAllClaims();
		assertTrue(response.size()==2);
	}

	@Test
	@Disabled
	void testDeleteClaimById() {
		boolean response = service.deleteClaimById((long) 1);
		assertTrue(response);
	}

	@Test
	@Disabled
	void testGetClaimsByPatientId() {
		List<Claims> response = service.getClaimsByPatientId(1);
		assertTrue(response.size()==2);
	}

	@Test
	@Disabled
	void testGetClaimsByStatus() {
		List<Claims> response = service.getClaimsByStatus("rejected");
		assertTrue(response.size()==0);
	}

	@Test
	@Disabled
	void testGetClaimsByPlanId() {
		List<Claims> response = service.getClaimsByPlanId(1);
		assertTrue(response.size()==2);
	}

}
