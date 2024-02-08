package com.hexaware.careassist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.careassist.dto.PatientDTO;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;

@SpringBootTest
class PatientServiceImpTest {

	@Autowired
	IPatientService service;

	@Test
	@Disabled
	void testAddPatient() {

		PatientDTO patientDto = new PatientDTO(101, LocalDate.of(2002, 04, 17), "1234567890", "abd abc abc", "king",
				"Male", "Pet Dard", "yash@gmail.com", "abc123");

		Patient p = service.addPatient(patientDto);

		assertEquals("king", p.getPatientName());

	}

	@Test
	@Disabled
	void testGetPatientById() throws NoSuchPatientFoundException {
		PatientDTO res = service.getPatientById(1);

		assertNotNull(res);
	}

	@Test
	@Disabled
	void testUpdatePatient() throws NoSuchPatientFoundException {
		PatientDTO patientDto = new PatientDTO(2, LocalDate.of(2002, 04, 17), "1234567890", "abd abc abc", "Kumar",
				"Male", "Kamar Dard", "kumar@gmail.com", "abc123");

		Patient p = service.updatePatient(patientDto);

		assertEquals("Kumar", p.getPatientName());
	}

	@Test
	@Disabled
	void testDeletePatientById() throws NoSuchPatientFoundException {
		
		boolean bool=service.deletePatientById(2);
		assertTrue(bool);
		
	}

	@Test
	@Disabled
	void testGetAllPatient() {
		List<Patient> list=service.getAllPatient();
		
		assertEquals(2,list.size());
	}

	@Test
	@Disabled
	void testGetPatientByName() {
		List<Patient> list=service.getPatientByName("Yash");
		
		assertEquals(1,list.size());
	}

}
