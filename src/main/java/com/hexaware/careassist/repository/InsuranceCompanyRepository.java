package com.hexaware.careassist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.InsuranceCompany;

/*
@Author :  Sheshank Sharma
Modified Date : 02-02-2024
Description : InsuranceCompanyRepository extending JpaRepository
*/

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long>{
	
	public Optional<InsuranceCompany> findByCompanyName(String companyName);

	public Optional<InsuranceCompany> findByEmail(String email);
}
