package com.hexaware.careassist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.dto.AuthRequest;
import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchAdminFoundException;
import com.hexaware.careassist.service.IAdminService;
import com.hexaware.careassist.service.JwtService;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestController {
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	private Logger logger=LoggerFactory.getLogger(AdminRestController.class);
	
	
	@PostMapping("/register")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public Admin addAdmin(@RequestBody AdminDTO adminDto) throws EmailAlreadyPresentException {
		return adminService.addAdmin(adminDto);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Admin updateAdmin(@RequestBody AdminDTO adminDto) throws NoSuchAdminFoundException, EmailAlreadyPresentException  {
		return adminService.updateAdmin(adminDto);
	}
	
	@GetMapping("/get/{adminId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public AdminDTO getAdminById(@PathVariable long adminId) throws NoSuchAdminFoundException {
		return adminService.getAdminById(adminId);
	}
	
	@PostMapping("/login")
	public String authenticateAndGenerateToken(@RequestBody AuthRequest authReq) {

		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authReq.getEmail(), authReq.getPassword()));

		
		String token = null;
		if (authenticate.isAuthenticated()) {
			token = jwtService.generateToken(authReq.getEmail());
			logger.info("JWT Token successfully generated!!!");
		}

		else {
			logger.info("EMAIL Not Found!!!!");
			throw new UsernameNotFoundException("EMAIL Not Found!!!! ");
		}
		return token;

	}
	
}
