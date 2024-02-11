package com.hexaware.careassist.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.careassist.dto.HealthCareProviderDTO;
import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchHealthCareProviderFoundException;
import com.hexaware.careassist.repository.HealthCareProviderRepository;

@Service
public class HealthCareProviderServiceImp implements IHealthCareProviderService {

	@Autowired
	HealthCareProviderRepository healthCareRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	Logger logger = LoggerFactory.getLogger(HealthCareProviderServiceImp.class);

	@Override
	public HealthCareProvider addHealthCareProvider(HealthCareProviderDTO healthCareProviderDto)
			throws EmailAlreadyPresentException {
		
		if (healthCareRepo.findByEmail(healthCareProviderDto.getEmail()).orElse(null) != null) {
			throw new EmailAlreadyPresentException("This email is already present in database");
		}
		
		healthCareProviderDto.setPassword(passwordEncoder.encode(healthCareProviderDto.getPassword()));

		HealthCareProvider healthcareprovider = healthCareRepo.save(new HealthCareProvider(
				healthCareProviderDto.getHealthCareProviderId(), healthCareProviderDto.getHealthcareProviderName(),
				healthCareProviderDto.getProviderGender(), healthCareProviderDto.getAddress(),
				healthCareProviderDto.getEmail(), healthCareProviderDto.getPassword()));
		
		logger.info("HealthCareProviderServiceImp - HealthCareProvider added successfully");
		
		return healthcareprovider;
	}

	@Override
	public HealthCareProviderDTO getHealthCareProviderById(long healthCareProviderId)
			throws NoSuchHealthCareProviderFoundException {
		
		HealthCareProvider healthcareprovider = healthCareRepo.findById(healthCareProviderId).orElseThrow(
				() -> new NoSuchHealthCareProviderFoundException("No such Health Care Provider exists in database"));
		
		logger.info("HealthCareProviderServiceImp - HealthCareProvider deleted successfully");
		
		return new HealthCareProviderDTO(healthcareprovider.getHealthCareProviderId(),
				healthcareprovider.getHealthCareProviderName(), healthcareprovider.getProviderGender(),
				healthcareprovider.getAddress(), healthcareprovider.getEmail(), healthcareprovider.getPassword());
	}

	@Override
	public HealthCareProvider updateHealthCareProvider(HealthCareProviderDTO healthCareProviderDto)
			throws NoSuchHealthCareProviderFoundException, EmailAlreadyPresentException {
		
		HealthCareProvider isPresent = healthCareRepo.findById(healthCareProviderDto.getHealthCareProviderId()).orElseThrow(
				() -> new NoSuchHealthCareProviderFoundException("No such Health Care Provider exists in database"));

		
		HealthCareProvider checkIfNew= healthCareRepo.findByEmail(healthCareProviderDto.getEmail()).orElse(null);


		if( checkIfNew == null ||(isPresent.getEmail().equals(healthCareProviderDto.getEmail()) )) {
			
			healthCareProviderDto.setPassword(passwordEncoder.encode(healthCareProviderDto.getPassword()));

			HealthCareProvider healthcareprovider = healthCareRepo.save(new HealthCareProvider(
					healthCareProviderDto.getHealthCareProviderId(), healthCareProviderDto.getHealthcareProviderName(),
					healthCareProviderDto.getProviderGender(), healthCareProviderDto.getAddress(),
					healthCareProviderDto.getEmail(), healthCareProviderDto.getPassword()));
			logger.info("HealthCareProviderServiceImp - HealthCareProvider updated successfully");
			return healthcareprovider;
			
		}else {
			
			throw new EmailAlreadyPresentException("This email is already registered in our database");
			
		}

		
		
	}

	@Override
	public boolean deleteHealthCareProvider(long healthCareProviderId) throws NoSuchHealthCareProviderFoundException {
		healthCareRepo.findById(healthCareProviderId).orElseThrow(
				() -> new NoSuchHealthCareProviderFoundException("No such Health Care Provider exists in database"));
		healthCareRepo.deleteById(healthCareProviderId);
		HealthCareProvider healthcareprovider = healthCareRepo.findById(healthCareProviderId).orElse(null);
		logger.info("HealthCareProviderServiceImp - HealthCareProvider deleted successfully");
		return healthcareprovider == null;
	}

	@Override
	public List<HealthCareProvider> getAllHealthCareProvider() {
		logger.info("HealthCareProviderServiceImp - All HealthCareProvider data fetched successfully");
		return healthCareRepo.findAll();
	}

}
