package com.hexaware.careassist.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.HealthCareProvider;


/*
@Author :  Sheshank Sharma
Modified Date : 02-02-2024
Description : HealthCareProviderRepository extending JpaRepository
*/

@Repository
public interface HealthCareProviderRepository extends JpaRepository<HealthCareProvider, Long>{

	Optional<HealthCareProvider> findByEmail(String email);
	
}
