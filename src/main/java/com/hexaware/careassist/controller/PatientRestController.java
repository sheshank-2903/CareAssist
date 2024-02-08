package com.hexaware.careassist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.careassist.dto.PatientDTO;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;
import com.hexaware.careassist.service.IPatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientRestController {

	@Autowired
	IPatientService service;

	@PostMapping("/add")
	public Patient addPatient(@RequestBody PatientDTO patientDto) {
		return service.addPatient(patientDto);
	}

	@PutMapping("/update")
	public Patient updatePatient(@RequestBody PatientDTO patientDto) throws NoSuchPatientFoundException {
		return service.updatePatient(patientDto);
	}

	@DeleteMapping("/delete/{patientId}")
	public String deletePatientById(@PathVariable long patientId) throws NoSuchPatientFoundException {
		boolean isDeleted = service.deletePatientById(patientId);
		return isDeleted ? "Patient has been deleted" : "Deletion unsuccessful";
	}

	@GetMapping("/getbyid/{patientId}")
	public PatientDTO getPatientById(@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.getPatientById(patientId);
	}

	@GetMapping("/getbyname/{patientName}")
	public List<Patient> getPatientByName(@PathVariable String patientName) {
		return service.getPatientByName(patientName);
	}

	@GetMapping("/getall")
	public List<Patient> getAllPatient() {
		return service.getAllPatient();
	}

}
