package com.hexaware.careassist.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.repository.AdminRepository;



@Service
public class AdminServiceImp implements IAdminService {
	
	
	
	@Autowired 
	AdminRepository repo;
	Logger logger =LoggerFactory.getLogger(AdminServiceImp.class);
	
	@Override
	public AdminDTO getAdminById(long adminId) {
		Admin admin = repo.findById(adminId).orElse(null);
		logger.info("AdminServiceImp - Admin data fetched successfully");
		AdminDTO adminDto = new AdminDTO(admin.getAdminId(),admin.getAdminName(),admin.getEmail(),admin.getPassword());
		return adminDto;
	}

	@Override
	public Admin updateAdmin(AdminDTO adminDto) {
		Admin admin = repo.save(new Admin(adminDto.getAdminId(),adminDto.getAdminName(),adminDto.getEmail(),adminDto.getPassword()));
		logger.info("AdminServiceImp - Admin has added updated successfull ");
		return admin;
	}

	@Override
	public Admin addAdmin(AdminDTO adminDto) {
		Admin admin = repo.save(new Admin(adminDto.getAdminId(),adminDto.getAdminName(),adminDto.getEmail(),adminDto.getPassword()));
		logger.info("AdminServiceImp - Admin has added successfull ");
		return admin;
	}


}
