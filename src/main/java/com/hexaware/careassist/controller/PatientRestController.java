package com.hexaware.careassist.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.careassist.dto.AuthRequest;
import com.hexaware.careassist.dto.PatientDTO;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;
import com.hexaware.careassist.service.IPatientService;
import com.hexaware.careassist.service.JwtService;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientRestController {

	@Autowired
	IPatientService service;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	private Logger logger=LoggerFactory.getLogger(AdminRestController.class);

	@PostMapping("/add")
	//@PreAuthorize("hasAuthority('PATIENT')")
	public Patient addPatient(@RequestBody PatientDTO patientDto) throws EmailAlreadyPresentException {
		return service.addPatient(patientDto);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('PATIENT')")
	public Patient updatePatient(@RequestBody PatientDTO patientDto) throws NoSuchPatientFoundException {
		return service.updatePatient(patientDto);
	}

	@DeleteMapping("/delete/{patientId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletePatientById(@PathVariable long patientId) throws NoSuchPatientFoundException {
		boolean isDeleted = service.deletePatientById(patientId);
		return isDeleted ? "Patient has been deleted" : "Deletion unsuccessful";
	}

	@GetMapping("/getbyid/{patientId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public PatientDTO getPatientById(@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.getPatientById(patientId);
	}

	
	@GetMapping("/getbyname/{patientName}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Patient> getPatientByName(@PathVariable String patientName) {
		return service.getPatientByName(patientName);
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Patient> getAllPatient() {
		return service.getAllPatient();
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGenerateToken(@RequestBody AuthRequest authReq) {

		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authReq.getEmail(), authReq.getPassword()));

		// If authentication is successful, generate a JWT
		String Token = null;
		if (authenticate.isAuthenticated()) {
			Token = jwtService.generateToken(authReq.getEmail());
			logger.info("JWT Token successfully generated!!!");
		}

		else {
			logger.info("EMAIL Not Found!!!!");
			throw new UsernameNotFoundException("EMAIL Not Found!!!! ");
		}
		return Token;

	}

}
