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
	public AdminDTO getAdminInfo(long adminId) {
		Admin admin = repo.findById(adminId).orElse(null);
		logger.info("AdminServiceImp - Admin data fetched successfully");
		AdminDTO adminDto = new AdminDTO(admin.getAdminId(),admin.getAdminName(),admin.getEmail(),admin.getPassword());
		return adminDto;
	}

	@Override
	public boolean updateAdminInfo(AdminDTO adminDto) {
		Admin admin = repo.save(new Admin(adminDto.getAdminId(),adminDto.getAdminName(),adminDto.getEmail(),adminDto.getPassword()));
		logger.info("AdminServiceImp - Admin has added updated successfull ");
		boolean result=true;
		if(admin==null)
			result=false;
		return result;
	}

	@Override
	public boolean addAdmin(AdminDTO adminDto) {
		Admin admin = repo.save(new Admin(adminDto.getAdminId(),adminDto.getAdminName(),adminDto.getEmail(),adminDto.getPassword()));
		logger.info("AdminServiceImp - Admin has added successfull ");
		boolean result=false;
		if(admin!=null)
			result=true;
		return result;
	}


}
