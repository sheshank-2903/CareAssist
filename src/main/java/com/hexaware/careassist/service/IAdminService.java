package com.hexaware.careassist.service;

import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchAdminFoundException;

/*
@Author :  Yash Dubey,Sheshank Sharma
Modified Date : 02-02-2024
Description : Creation of AdminService interface
*/

public interface IAdminService {
	public AdminDTO getAdminById(long adminId) throws NoSuchAdminFoundException; 
	public Admin updateAdmin(AdminDTO adminDto) throws NoSuchAdminFoundException, EmailAlreadyPresentException;
	public Admin addAdmin(AdminDTO adminDto) throws EmailAlreadyPresentException;
	
}
