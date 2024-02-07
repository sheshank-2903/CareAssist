package com.hexaware.careassist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.exceptions.NoSuchAdminFoundException;
import com.hexaware.careassist.service.IAdminService;


@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	
	@Autowired
	IAdminService adminService;
	
	@PostMapping("/add")
	public Admin addAdmin(@RequestBody AdminDTO adminDto) {
		return adminService.addAdmin(adminDto);
	}
	
	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody AdminDTO adminDto) throws NoSuchAdminFoundException  {
		return adminService.updateAdmin(adminDto);
	}
	
	@GetMapping("/get/{adminId}")
	public AdminDTO getAdminById(@PathVariable long adminId) throws NoSuchAdminFoundException {
		return adminService.getAdminById(adminId);
	}
	
}
