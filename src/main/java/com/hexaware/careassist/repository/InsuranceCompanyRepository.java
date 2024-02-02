package com.hexaware.careassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.careassist.entities.InsuranceCompany;


public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long>{
	
}
