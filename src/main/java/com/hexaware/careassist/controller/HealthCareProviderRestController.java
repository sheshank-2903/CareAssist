package com.hexaware.careassist.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexaware.careassist.dto.HealthCareProviderDTO;
import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.service.IHealthCareProviderService;


@RestController
@RequestMapping("/api/healthcareprovider")
public class HealthCareProviderRestController {
	
	@Autowired
	IHealthCareProviderService healthCareProviderService;
	Logger logger = LoggerFactory.getLogger(HealthCareProviderRestController.class);
	
	@PostMapping("/add")
	public HealthCareProvider addHealthCareProvider(@RequestBody HealthCareProviderDTO healthCareProviderDto) {
		logger.info("HealthCareProviderRestController - HealthCareProvider added successfully");
		return healthCareProviderService.addHealthCareProvider(healthCareProviderDto);
	}
	
	@GetMapping("/get/{healthCareProviderId}")
	public HealthCareProviderDTO getHealthCareProviderById(@PathVariable long healthCareProviderId) {
		logger.info("HealthCareProviderRestController - HealthCareProvider data by Id fetched successfully");
		return healthCareProviderService.getHealthCareProviderById(healthCareProviderId);
	} 
	
	@PutMapping("/update")
	public HealthCareProvider updateHealthCareProvider(@RequestBody HealthCareProviderDTO healthCareProviderDto) {
		logger.info("HealthCareProviderRestController - HealthCareProvider updated successfully");
		return healthCareProviderService.updateHealthCareProvider(healthCareProviderDto);
	}

	@DeleteMapping("/delete")
	public boolean deleteHealthCareProvider(@RequestBody long healthCareProviderId) {
		logger.info("HealthCareProviderRestController - HealthCareProvider deleted successfully");
		return healthCareProviderService.deleteHealthCareProvider(healthCareProviderId);
	}
	
	@GetMapping("/getall")
	public List<HealthCareProvider> getAllHealthCareProvider() {
		logger.info("HealthCareProviderRestController - All HealthCareProvider data fetched successfully");
		return healthCareProviderService.getAllHealthCareProvider();
	}
}
