package com.hexaware.careassist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Long>{

	List<Plans> findByPlanName(String planName);
	
	@Query("select plans from Plans  plans where plans.insuranceCompany.companyName=?1")
	List<Plans> findByCompanyName(String companyName);

}
