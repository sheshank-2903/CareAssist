package com.hexaware.careassist.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexaware.careassist.dto.AuthRequest;
import com.hexaware.careassist.dto.PatientDTO;
import com.hexaware.careassist.dto.PurchaseResponse;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.entities.Plans;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.InvalidInputException;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;
import com.hexaware.careassist.exceptions.NoSuchPlanFoundException;
import com.hexaware.careassist.service.IPatientService;
import com.hexaware.careassist.service.JwtService;

/*
@Author :  Yash Dubey
Modified Date : 05-02-2024
Description : Creation of PatientRestController
*/

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin(origins="http://localhost:4200")
public class PatientRestController {

	@Autowired
	IPatientService service;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	private Logger logger=LoggerFactory.getLogger(PatientRestController.class);

	@PostMapping(value="/register",consumes = "multipart/form-data")
	public Patient addPatient(@RequestPart String patientDtoStringified,@RequestPart("file") MultipartFile file) throws EmailAlreadyPresentException,InvalidInputException {
		ObjectMapper mapper = new ObjectMapper();
		 PatientDTO patientDto=null;
		try {
			
			JsonNode jsonNode=mapper.readTree(patientDtoStringified);
			String dobAsString = jsonNode.get("dob").asText();

			LocalDate dob = LocalDate.parse(dobAsString);
			patientDto=new PatientDTO(1,dob, jsonNode.get("contact").asText(),
					jsonNode.get("address").asText(),jsonNode.get("patientName").asText(),jsonNode.get("patientGender").asText(),
					jsonNode.get("descriptionOfTreatment").asText(),jsonNode.get("email").asText(),
					jsonNode.get("password").asText());
		} catch (JsonMappingException e) {
			throw new InvalidInputException("invalid Input Exception");
		} catch (JsonProcessingException e) {
			throw new InvalidInputException("invalid Input Exception");
		}
		return service.addPatient(patientDto,file);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('PATIENT')")
	public Patient updatePatient(@RequestBody PatientDTO patientDto) throws NoSuchPatientFoundException, EmailAlreadyPresentException {
		return service.updatePatient(patientDto);
	}

	@DeleteMapping("/delete/{patientId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public boolean deletePatientById(@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.deletePatientById(patientId);
	}

	@GetMapping("/getById/{patientId}")
	@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('HEALTH_CARE_PROVIDER') || hasAuthority('PATIENT')")
	public Patient getPatientById(@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.getPatientById(patientId);
	}
	
	@GetMapping("/getByEmail/{email}")
	@PreAuthorize("hasAuthority('PATIENT')")
	public PatientDTO getPatientByEmail(@PathVariable String email) throws NoSuchPatientFoundException {
		return service.getPatientByEmail(email);
	}

	
	@GetMapping("/getByName/{patientName}")
	@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('HEALTH_CARE_PROVIDER')")
	public List<Patient> getPatientByName(@PathVariable String patientName) {
		return service.getPatientByName(patientName);
	}

	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('HEALTH_CARE_PROVIDER')")
	public List<Patient> getAllPatient() {
		return service.getAllPatient();
	}
	
	@PutMapping("/purchasePlan/{patientId}/{planId}")
	@PreAuthorize("hasAuthority('PATIENT')")
	public PurchaseResponse purchasePlan(@PathVariable long patientId,@PathVariable long planId) throws NoSuchPlanFoundException, NoSuchPatientFoundException {
		String message = service.purchasePlan(patientId, planId);
        return new PurchaseResponse(message);
	}
	
	@GetMapping("/getAllPurchasedPlans/{patientId}")
	@PreAuthorize("hasAuthority('PATIENT')")
	public Set<Plans> getAllPurchasedPlans(@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.getAllPurchasedPlans(patientId);
	}
	
	@PostMapping("/login")
	public String authenticateAndGenerateToken(@RequestBody AuthRequest authReq) {

		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authReq.getEmail(), authReq.getPassword()));

		
		String token = null;
		if (authenticate.isAuthenticated()) {
			token = jwtService.generateToken(authReq.getEmail(),"PATIENT");
			logger.info("JWT Token successfully generated!!!");
		}

		else {
			logger.info("EMAIL Not Found!!!!");
			throw new UsernameNotFoundException("EMAIL Not Found!!!! ");
		}
		return token;

	}
	
	@PutMapping("/updateProfilePicture/{patientId}")
	@PreAuthorize("hasAuthority('PATIENT')")
	public Patient updateProfilePicture(@PathVariable long patientId,@RequestParam("patientProfilePicture") MultipartFile patientProfilePicture) throws NoSuchPatientFoundException {
		if (patientProfilePicture != null) {
	        byte[] profilePictureBytes;
	        try {
	            profilePictureBytes = patientProfilePicture.getBytes();
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to read the profile picture file", e);
	        }
	        return service.updateProfilePicture(patientId, profilePictureBytes);
	    } else {
	        throw new IllegalArgumentException("Patient profile picture is required");
	    }
		
	}

	
}
