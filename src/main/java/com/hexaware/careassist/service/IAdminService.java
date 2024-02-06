package com.hexaware.careassist.service;

import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.entities.Admin;


public interface IAdminService {
	public AdminDTO getAdminById(long adminId);
	public Admin updateAdmin(AdminDTO adminDto);
	public Admin addAdmin(AdminDTO adminDto);
	
}
