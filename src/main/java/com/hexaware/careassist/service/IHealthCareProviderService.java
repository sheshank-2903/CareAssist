package com.hexaware.careassist.service;
import java.util.List;

import com.hexaware.careassist.dto.HealthCareProviderDTO;
import com.hexaware.careassist.entities.HealthCareProvider;


public interface IHealthCareProviderService {
	public HealthCareProvider addHealthCareProvider(HealthCareProviderDTO healthCareProviderDto);
	public HealthCareProviderDTO getHealthCareProviderById(long healthCareProviderId);
	public HealthCareProvider updateHealthCareProvider(HealthCareProviderDTO healthCareProviderDto);
	public boolean deleteHealthCareProvider(long healthCareProviderId);
	public List<HealthCareProvider> getAllHealthCareProvider();
}
