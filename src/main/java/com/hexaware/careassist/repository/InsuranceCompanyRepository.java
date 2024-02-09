package com.hexaware.careassist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.InsuranceCompany;

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long>{
	
	public Optional<InsuranceCompany> findBycompanyName(String companyName);

	public Optional<InsuranceCompany> findByEmail(String email);
}
