package com.hexaware.careassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Long>{

}
