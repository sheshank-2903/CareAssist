package com.hexaware.careassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.careassist.entities.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long>{
	
}
