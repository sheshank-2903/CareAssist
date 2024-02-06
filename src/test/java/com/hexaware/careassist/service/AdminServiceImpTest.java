package com.hexaware.careassist.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.entities.Admin;

@SpringBootTest
class AdminServiceImpTest {

	@Autowired
	IAdminService  service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testGetAdminInfo() {
		AdminDTO response=service.getAdminById(1);
		assertTrue(response.getAdminId()==1);
	}

	@Test
	@Disabled
	void testUpdateAdminInfo() {
		Admin response=service.updateAdmin(new AdminDTO(1,"name","admin@gmail.com","password"));
		assertTrue(response.getAdminName()=="name" && response.getEmail()=="admin@gmail.com");
	}

	@Test
	@Disabled
	void testAddAdmin() {
		Admin response=service.addAdmin(new AdminDTO(2,"king","email@gmail.com","password"));
		assertTrue(response.getAdminName()=="king" && response.getEmail()=="email@gmail.com");
	}

}
