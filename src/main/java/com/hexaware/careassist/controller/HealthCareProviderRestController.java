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
import com.hexaware.careassist.exceptions.NoSuchHealthCareProviderFoundException;
import com.hexaware.careassist.service.IHealthCareProviderService;


@RestController
@RequestMapping("/api/healthcareprovider")
public class HealthCareProviderRestController {
	
	@Autowired
	IHealthCareProviderService healthCareProviderService;
	
	@PostMapping("/add")
	public HealthCareProvider addHealthCareProvider(@RequestBody HealthCareProviderDTO healthCareProviderDto) {
		return healthCareProviderService.addHealthCareProvider(healthCareProviderDto);
	}
	
	@GetMapping("/get/{healthCareProviderId}")
	public HealthCareProviderDTO getHealthCareProviderById(@PathVariable long healthCareProviderId) throws NoSuchHealthCareProviderFoundException {
		return healthCareProviderService.getHealthCareProviderById(healthCareProviderId);
	} 
	
	@PutMapping("/update")
	public HealthCareProvider updateHealthCareProvider(@RequestBody HealthCareProviderDTO healthCareProviderDto) throws NoSuchHealthCareProviderFoundException {
		return healthCareProviderService.updateHealthCareProvider(healthCareProviderDto);
	}

	@DeleteMapping("/delete")
	public boolean deleteHealthCareProvider(@RequestBody long healthCareProviderId) {
		return healthCareProviderService.deleteHealthCareProvider(healthCareProviderId);
	}
	
	@GetMapping("/getall")
	public List<HealthCareProvider> getAllHealthCareProvider() {
		return healthCareProviderService.getAllHealthCareProvider();
	}
}
