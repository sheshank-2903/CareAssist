package com.hexaware.careassist.service;

import com.hexaware.careassist.dto.AdminDTO;


public interface IAdminService {
	public AdminDTO getAdminInfo(long adminId);
	public boolean updateAdminInfo(AdminDTO adminDto);
	public boolean addAdmin(AdminDTO adminDto);
	
}
