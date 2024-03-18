package com.hexaware.careassist.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.InvalidInputException;
import com.hexaware.careassist.exceptions.NoSuchAdminFoundException;

/*
@Author :  Yash Dubey,Sheshank Sharma
Modified Date : 02-02-2024
Description : Creation of AdminService interface
*/

public interface IAdminService {
	public AdminDTO getAdminById(long adminId) throws NoSuchAdminFoundException; 
	public Admin updateAdmin(AdminDTO adminDto,MultipartFile file) throws NoSuchAdminFoundException, EmailAlreadyPresentException, InvalidInputException;
	public Admin addAdmin(AdminDTO adminDto,MultipartFile file) throws EmailAlreadyPresentException, InvalidInputException;
	public AdminDTO getAdminByEmail(String email) throws NoSuchAdminFoundException; 
	public List<Admin> getAllAdmin();
	public boolean deleteAdminById(long adminId) throws NoSuchAdminFoundException;
	public List<Admin> getAdminByName(String adminName);
	
}
