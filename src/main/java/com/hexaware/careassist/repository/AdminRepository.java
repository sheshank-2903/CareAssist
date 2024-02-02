package com.hexaware.careassist.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.careassist.entities.Admin;



public interface AdminRepository extends JpaRepository<Admin, Long>{
	
}
