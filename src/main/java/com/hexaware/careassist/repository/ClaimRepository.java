package com.hexaware.careassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.careassist.entities.Claims;

public interface ClaimRepository extends JpaRepository<Claims, Long> {

}
