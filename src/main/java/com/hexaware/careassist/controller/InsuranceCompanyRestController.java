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
import com.hexaware.careassist.dto.InsuranceCompanyDTO;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchInsuranceCompanyFoundException;
import com.hexaware.careassist.service.IInsuranceCompanyService;
import com.hexaware.careassist.service.JwtService;

@RestController
@RequestMapping("/api/v1/insurancecompany")
public class InsuranceCompanyRestController {
	
	@Autowired
	IInsuranceCompanyService insuranceCompanyService; 
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	private Logger logger =LoggerFactory.getLogger(InsuranceCompanyRestController.class);
	
	
	
	@GetMapping("/get/{insuranceCompanyId}")
	@PreAuthorize("hasAuthority('INSURANCE_COMPANY') || hasAuthority('ADMIN')")
	public InsuranceCompanyDTO getInsuranceCompanyById(@PathVariable long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException {
		
		return insuranceCompanyService.getInsuranceCompanyById(insuranceCompanyId);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('INSURANCE_COMPANY') || hasAuthority('ADMIN')")
	public InsuranceCompany updateInsuranceCompany(@RequestBody InsuranceCompanyDTO insuranceCompanyDto) throws NoSuchInsuranceCompanyFoundException {
		
		return insuranceCompanyService.updateInsuranceCompany(insuranceCompanyDto);
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InsuranceCompany> getAllInsuranceCompany(){
		return insuranceCompanyService.getAllInsuranceCompany();
	}

	@DeleteMapping("/delete/{insuranceCompanyId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public boolean deleteInsuranceCompanyById(@PathVariable long insuranceCompanyId) throws NoSuchInsuranceCompanyFoundException {
		
		return insuranceCompanyService.deleteInsuranceCompanyById(insuranceCompanyId);
	}
	
	@PostMapping("/add")
	public InsuranceCompany addInsuranceCompany(@RequestBody InsuranceCompanyDTO insuranceCompanyDto) throws EmailAlreadyPresentException {
		
		return insuranceCompanyService.addInsuranceCompany(insuranceCompanyDto);
	}
	
	
	@GetMapping("/getbyname/{insuranceCompanyName}")
	@PreAuthorize("hasAuthority('INSURANCE_COMPANY') || hasAuthority('ADMIN')")
	public InsuranceCompany getInsuranceCompanyByName(@PathVariable String insuranceCompanyName) throws NoSuchInsuranceCompanyFoundException {
		
		return insuranceCompanyService.getInsuranceCompanyByName(insuranceCompanyName);
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
