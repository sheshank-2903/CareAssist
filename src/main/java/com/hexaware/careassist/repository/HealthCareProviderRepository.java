package com.hexaware.careassist.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.careassist.entities.HealthCareProvider;



public interface HealthCareProviderRepository extends JpaRepository<HealthCareProvider, Long>{
	
}
