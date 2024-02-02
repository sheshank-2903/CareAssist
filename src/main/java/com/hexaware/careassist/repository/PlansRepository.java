package com.hexaware.careassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.careassist.entities.Plans;

public interface PlansRepository extends JpaRepository<Plans, Long>{

}
