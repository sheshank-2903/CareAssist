package com.hexaware.careassist.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.HealthCareProvider;


@Repository
public interface HealthCareProviderRepository extends JpaRepository<HealthCareProvider, Long>{
	
}
