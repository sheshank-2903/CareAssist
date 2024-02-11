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
import com.hexaware.careassist.dto.HealthCareProviderDTO;
import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchHealthCareProviderFoundException;
import com.hexaware.careassist.service.IHealthCareProviderService;
import com.hexaware.careassist.service.JwtService;


@RestController
@RequestMapping("/api/v1/healthcareprovider")
public class HealthCareProviderRestController {
	
	@Autowired
	IHealthCareProviderService healthCareProviderService;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	private Logger logger=LoggerFactory.getLogger(HealthCareProviderRestController.class);
	
	@PostMapping("/add")
	public HealthCareProvider addHealthCareProvider(@RequestBody HealthCareProviderDTO healthCareProviderDto) throws EmailAlreadyPresentException {
		return healthCareProviderService.addHealthCareProvider(healthCareProviderDto);
	}
	
	@GetMapping("/get/{healthCareProviderId}")
	@PreAuthorize("hasAuthority('HEALTH_CARE_PROVIDER') || hasAuthority('ADMIN')")
	public HealthCareProviderDTO getHealthCareProviderById(@PathVariable long healthCareProviderId) throws NoSuchHealthCareProviderFoundException {
		return healthCareProviderService.getHealthCareProviderById(healthCareProviderId);
	} 
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('HEALTH_CARE_PROVIDER') || hasAuthority('ADMIN')")
	public HealthCareProvider updateHealthCareProvider(@RequestBody HealthCareProviderDTO healthCareProviderDto) throws NoSuchHealthCareProviderFoundException, EmailAlreadyPresentException {
		return healthCareProviderService.updateHealthCareProvider(healthCareProviderDto);
	}

	@DeleteMapping("/delete/{healthCareProviderId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public boolean deleteHealthCareProvider(@PathVariable long healthCareProviderId) throws NoSuchHealthCareProviderFoundException {
		return healthCareProviderService.deleteHealthCareProvider(healthCareProviderId);
	}
	
	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<HealthCareProvider> getAllHealthCareProvider() {
		return healthCareProviderService.getAllHealthCareProvider();
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
