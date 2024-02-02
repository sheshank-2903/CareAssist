package com.hexaware.careassist.service;
import java.util.List;

import com.hexaware.careassist.dto.HealthCareProviderDTO;
import com.hexaware.careassist.entities.HealthCareProvider;


public interface IHealthCareProviderService {
	public boolean addHealthCareProvider(HealthCareProviderDTO healthCareProviderDto);
	public HealthCareProviderDTO getHealthCareProviderById(int healthCareProviderId);
	public boolean updateHealthCareProviderInfo(HealthCareProviderDTO healthCareProviderDto);
	public boolean deleteHealthCareProviderInfo(int healthCareProviderId);
	public List<HealthCareProvider> getAllHealthCareProvider();
}
