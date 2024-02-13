package com.hexaware.careassist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.Plans;


/*
@Author :  Yash Dubey
Modified Date : 02-02-2024
Description : PlansRepository extending JpaRepository
*/

@Repository
public interface PlansRepository extends JpaRepository<Plans, Long>{

	List<Plans> findByPlanName(String planName);
	
	@Query("select plans from Plans  plans where plans.insuranceCompany.companyName=?1")
	List<Plans> findByCompanyName(String companyName);
	
	List<Plans> findByCoverageAmountLessThan(double coverageAmount);
	
	@Query(value="select insurance_plan_id from patient_insurance_plan where patient_id=?1",nativeQuery=true)
	List<Long> findByPatientId(long patientId);


}
