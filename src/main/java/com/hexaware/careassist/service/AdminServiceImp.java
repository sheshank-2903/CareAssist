package com.hexaware.careassist.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchAdminFoundException;
import com.hexaware.careassist.repository.AdminRepository;



@Service
public class AdminServiceImp implements IAdminService {
	
	@Autowired 
	AdminRepository repo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	Logger logger =LoggerFactory.getLogger(AdminServiceImp.class);
	
	@Override
	public AdminDTO getAdminById(long adminId) throws NoSuchAdminFoundException {
		Admin admin = repo.findById(adminId).orElseThrow(()-> new NoSuchAdminFoundException("No such admin exists in database"));
		logger.info("AdminServiceImp - Admin data fetched successfully");
		AdminDTO adminDto = new AdminDTO(admin.getAdminId(),admin.getAdminName(),admin.getEmail(),admin.getPassword());
		return adminDto;
	}

	@Override
	public Admin updateAdmin(AdminDTO adminDto) throws NoSuchAdminFoundException, EmailAlreadyPresentException {
		if(repo.findByEmail(adminDto.getEmail()).orElse(null)!=null) {
			throw new EmailAlreadyPresentException("This email is already present in database");
		}
		repo.findById(adminDto.getAdminId()).orElseThrow(()-> new NoSuchAdminFoundException("No such admin exists in database"));
		adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
		Admin admin = repo.save(new Admin(adminDto.getAdminId()
								,adminDto.getAdminName()
								,adminDto.getEmail()
								,adminDto.getPassword()));
		logger.info("AdminServiceImp - Admin has added updated successfull ");
		return admin;
	}

	@Override
	public Admin addAdmin(AdminDTO adminDto) throws EmailAlreadyPresentException {
		if(repo.findByEmail(adminDto.getEmail()).orElse(null)!=null) {
			throw new EmailAlreadyPresentException("This email is already present in database");
		}
		adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
		System.out.println("Password ************** " + adminDto.getPassword());
		Admin admin = repo.save(new Admin(adminDto.getAdminId(),adminDto.getAdminName(),adminDto.getEmail(),adminDto.getPassword()));
		logger.info("AdminServiceImp - Admin has added successfull ");
		return admin;
	}


}
