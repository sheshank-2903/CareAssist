package com.hexaware.careassist.controller;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.dto.AuthRequest;
import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.InvalidInputException;
import com.hexaware.careassist.exceptions.NoSuchAdminFoundException;
import com.hexaware.careassist.service.IAdminService;
import com.hexaware.careassist.service.JwtService;

/*
@Author :  Yash Dubey,Sheshank Sharma
Modified Date : 05-02-2024
Description : Creation of AdminRestController
*/


@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminRestController {
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	private Logger logger=LoggerFactory.getLogger(AdminRestController.class);
	
	
	
	@PostMapping(value="/register",consumes = "multipart/form-data")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public Admin addAdmin(@RequestPart String adminDtoStringified,@RequestPart("file") MultipartFile file ) throws EmailAlreadyPresentException, InvalidInputException {
		ObjectMapper mapper = new ObjectMapper();
		 AdminDTO adminDto=null;
		try {
			JsonNode jsonNode=mapper.readTree(adminDtoStringified);
			adminDto=new AdminDTO(1,jsonNode.get("adminName").asText(),jsonNode.get("email").asText(),jsonNode.get("password").asText());
		} catch (JsonMappingException e) {
			throw new InvalidInputException("invalid Input Exception");
		} catch (JsonProcessingException e) {
			throw new InvalidInputException("invalid Input Exception");
		}
		return adminService.addAdmin(adminDto,file);
	}
	
//	@RequestParam("file") MultipartFile file, @ModelAttribute AdminDTO adminDto
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Admin updateAdmin(@RequestBody AdminDTO adminDto ,@RequestParam("file") MultipartFile file) throws NoSuchAdminFoundException, EmailAlreadyPresentException, InvalidInputException  {
		return adminService.updateAdmin(adminDto,file);
	}
	
	@GetMapping("/get/{adminId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Admin getAdminById(@PathVariable long adminId) throws NoSuchAdminFoundException {
		return adminService.getAdminById(adminId);
	}
	
	@GetMapping("/getByEmail/{email}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Admin getAdminByEmail(@PathVariable String email) throws NoSuchAdminFoundException {
		return adminService.getAdminByEmail(email);
	}
	
	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}
	
	@DeleteMapping("/delete/{adminId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public boolean deleteAdmin(@PathVariable long adminId) throws NoSuchAdminFoundException {
		return adminService.deleteAdminById(adminId);
	}
	
	
	@PostMapping("/login")
	public String authenticateAndGenerateToken(@RequestBody AuthRequest authReq) throws NoSuchAdminFoundException {

		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authReq.getEmail(), authReq.getPassword()));

		
		String token = null;
		if (authenticate.isAuthenticated()) {
			token = jwtService.generateToken(authReq.getEmail(),"ADMIN"); // change - 9
			logger.info("JWT Token successfully generated!!!");
		}

		else {
			logger.info("EMAIL Not Found!!!!");
			throw new NoSuchAdminFoundException("No Such Admin Found");
		}
		return token;

	}
	
	@GetMapping("/getAdminByName/{adminName}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Admin> getAdminByName(@PathVariable String adminName) {
		return adminService.getAdminByName(adminName);
	}
	
	@PutMapping("/updateProfilePicture/{adminId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Admin updateProfilePicture(@PathVariable long adminId,@RequestParam("adminProfilePicture") MultipartFile adminProfilePicture) throws NoSuchAdminFoundException {
		if (adminProfilePicture != null) {
	        byte[] profilePictureBytes;
	        try {
	            profilePictureBytes = adminProfilePicture.getBytes();
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to read the profile picture file", e);
	        }
	        return adminService.updateProfilePicture(adminId, profilePictureBytes);
	    } else {
	        throw new IllegalArgumentException("Admin profile picture is required");
	    }
		
	}
	
}
