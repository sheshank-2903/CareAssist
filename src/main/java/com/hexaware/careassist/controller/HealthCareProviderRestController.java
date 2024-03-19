package com.hexaware.careassist.controller;

import java.io.IOException;
import java.util.List;
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
import com.hexaware.careassist.dto.HealthCareProviderDTO;
import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.InvalidInputException;
import com.hexaware.careassist.exceptions.NoSuchHealthCareProviderFoundException;
import com.hexaware.careassist.service.IHealthCareProviderService;
import com.hexaware.careassist.service.JwtService;

/*
@Author :  Sheshank Sharma
Modified Date : 05-02-2024
Description : Creation of HealthCareProviderRestController
*/

@RestController
@RequestMapping("/api/v1/healthcareprovider")
@CrossOrigin(origins="http://localhost:4200")
public class HealthCareProviderRestController {
	
	@Autowired
	IHealthCareProviderService healthCareProviderService;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	private Logger logger=LoggerFactory.getLogger(HealthCareProviderRestController.class);
	
	@PostMapping(value="/register",consumes = "multipart/form-data")
	public HealthCareProvider addHealthCareProvider(@RequestPart String healthCareProviderDtoStringified,@RequestPart("file") MultipartFile file) throws EmailAlreadyPresentException, InvalidInputException {
		ObjectMapper mapper = new ObjectMapper();
		 HealthCareProviderDTO healthCareProviderDTO=null;
		try {
			
			JsonNode jsonNode=mapper.readTree(healthCareProviderDtoStringified);
			healthCareProviderDTO=new HealthCareProviderDTO(1, jsonNode.get("healthCareProviderName").asText(),
					jsonNode.get("providerGender").asText(),jsonNode.get("address").asText(),jsonNode.get("email").asText(),
					jsonNode.get("password").asText());
		} catch (JsonMappingException e) {
			throw new InvalidInputException("invalid Input Exception");
		} catch (JsonProcessingException e) {
			throw new InvalidInputException("invalid Input Exception");
		}
		return healthCareProviderService.addHealthCareProvider(healthCareProviderDTO,file);
	}
	
	@GetMapping("/get/{healthCareProviderId}")
	@PreAuthorize("hasAuthority('HEALTH_CARE_PROVIDER') || hasAuthority('ADMIN') || hasAuthority('PATIENT')")
	public HealthCareProviderDTO getHealthCareProviderById(@PathVariable long healthCareProviderId) throws NoSuchHealthCareProviderFoundException {
		return healthCareProviderService.getHealthCareProviderById(healthCareProviderId);
	} 
	
	@GetMapping("/getCompleteHealthCareProviderById/{healthCareProviderId}")
	@PreAuthorize("hasAuthority('HEALTH_CARE_PROVIDER')")
	public HealthCareProvider getCompleteHealthCareProviderById(@PathVariable long healthCareProviderId) throws NoSuchHealthCareProviderFoundException {
		return healthCareProviderService.getCompleteHealthCareProviderById(healthCareProviderId);
	}
	
	@GetMapping("/getByEmail/{email}")
	@PreAuthorize("hasAuthority('HEALTH_CARE_PROVIDER')")
	public HealthCareProviderDTO getHealthCareProviderByEmail(@PathVariable String email) throws NoSuchHealthCareProviderFoundException {
		return healthCareProviderService.getHealthCareProviderByEmail(email);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('HEALTH_CARE_PROVIDER') || hasAuthority('ADMIN')")
	public HealthCareProvider updateHealthCareProvider(@RequestBody HealthCareProviderDTO healthCareProviderDto) throws NoSuchHealthCareProviderFoundException, EmailAlreadyPresentException, InvalidInputException {
		return healthCareProviderService.updateHealthCareProvider(healthCareProviderDto);
	}

	@DeleteMapping("/delete/{healthCareProviderId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public boolean deleteHealthCareProvider(@PathVariable long healthCareProviderId) throws NoSuchHealthCareProviderFoundException {
		return healthCareProviderService.deleteHealthCareProvider(healthCareProviderId);
	}
	
	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ADMIN')|| hasAuthority('PATIENT')")
	public List<HealthCareProvider> getAllHealthCareProvider() {
		return healthCareProviderService.getAllHealthCareProvider();
	}
	
	@PostMapping("/login")
	public String authenticateAndGenerateToken(@RequestBody AuthRequest authReq) {

		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authReq.getEmail(), authReq.getPassword()));

		
		String token = null;
		if (authenticate.isAuthenticated()) {
			token = jwtService.generateToken(authReq.getEmail(),"HEALTH_CARE_PROVIDER");
			logger.info("JWT Token successfully generated!!!");
		}

		else {
			logger.info("EMAIL Not Found!!!!");
			throw new UsernameNotFoundException("EMAIL Not Found!!!! ");
		}
		return token;

	}
	
	@GetMapping("/getHealthCareProviderByName/{healthCareProviderName}")
	@PreAuthorize("hasAuthority('ADMIN')|| hasAuthority('PATIENT')")
	public List<HealthCareProvider> getHealthCareProviderByName(@PathVariable String healthCareProviderName) {
		return healthCareProviderService.getHealthCareProviderByName(healthCareProviderName);
	}

	
	@PutMapping("/updateProfilePicture/{healthCareProviderId}")
	@PreAuthorize("hasAuthority('HEALTH_CARE_PROVIDER')")
	public HealthCareProvider updateProfilePicture(@PathVariable long healthCareProviderId,@RequestParam("healthCareProviderProfilePicture") MultipartFile healthCareProviderProfilePicture) throws NoSuchHealthCareProviderFoundException {
		if (healthCareProviderProfilePicture != null) {
	        byte[] profilePictureBytes;
	        try {
	            profilePictureBytes = healthCareProviderProfilePicture.getBytes();
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to read the profile picture file", e);
	        }
	        return healthCareProviderService.updateProfilePicture(healthCareProviderId, profilePictureBytes);
	    } else {
	        throw new IllegalArgumentException("Health Care Provider profile picture is required");
	    }
		
	}
}
