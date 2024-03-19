package com.hexaware.careassist.service;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.hexaware.careassist.dto.AdminDTO;
import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.InvalidInputException;
import com.hexaware.careassist.exceptions.NoSuchAdminFoundException;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;
import com.hexaware.careassist.repository.AdminRepository;
import com.hexaware.careassist.repository.HealthCareProviderRepository;
import com.hexaware.careassist.repository.InsuranceCompanyRepository;
import com.hexaware.careassist.repository.PatientRepository;

/*
@Author :  Yash Dubey,Sheshank Sharma
Modified Date : 02-02-2024
Description : implementation of AdminService
*/

@Service
public class AdminServiceImp implements IAdminService {
	
	@Autowired 
	AdminRepository repo;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	HealthCareProviderRepository healthCareRepo;
	
	@Autowired
	InsuranceCompanyRepository insuranceRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	Logger logger =LoggerFactory.getLogger(AdminServiceImp.class);
	
	@Override
	public Admin getAdminById(long adminId) throws NoSuchAdminFoundException {
		Admin admin = repo.findById(adminId).orElseThrow(()-> new NoSuchAdminFoundException("No such admin exists in database"));
		logger.info("AdminServiceImp - Admin data fetched successfully");
		return new Admin(admin.getAdminId(),admin.getAdminName(),admin.getEmail(),admin.getPassword(),admin.getAdminProfilePic());
	}
	

	@Override
	public Admin updateAdmin(AdminDTO adminDto,MultipartFile file) throws NoSuchAdminFoundException, EmailAlreadyPresentException, InvalidInputException {
		
		Admin isPresent=repo.findById(adminDto.getAdminId()).orElseThrow(()-> new NoSuchAdminFoundException("No such admin exists in database"));
		
		Admin checkIfNew=repo.findByEmail(adminDto.getEmail()).orElse(null);
		
		if( checkIfNew == null ||(isPresent.getEmail().equals(adminDto.getEmail()) )) {
			
			adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
			Admin admin;
			try {
				admin = repo.save(new Admin(adminDto.getAdminId()
						,adminDto.getAdminName()
						,adminDto.getEmail()
						,adminDto.getPassword(),file.getBytes()));
			} catch (IOException e) {
				throw new InvalidInputException("image uploaded failed");
			}
			logger.info("AdminServiceImp - Admin has added updated successfully");
			return admin;
			}else {
				throw new EmailAlreadyPresentException("This email is already registered in our database");
			}
		
	}

	@Override
	public Admin addAdmin(AdminDTO adminDto,MultipartFile file) throws EmailAlreadyPresentException, InvalidInputException {
		if(repo.findByEmail(adminDto.getEmail()).orElse(null)!=null || 
				patientRepo.findByEmail(adminDto.getEmail()).orElse(null)!=null ||
				healthCareRepo.findByEmail(adminDto.getEmail()).orElse(null)!=null ||
				insuranceRepo.findByEmail(adminDto.getEmail()).orElse(null)!=null) {
			throw new EmailAlreadyPresentException("This email is already present in database");
		}
		adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
		Admin admin;
		try {
			admin = repo.save(new Admin(adminDto.getAdminId(),adminDto.getAdminName(),adminDto.getEmail(),adminDto.getPassword(),file.getBytes()));
		} catch (IOException e) {
			throw new InvalidInputException("image uploaded failed");
		}
		logger.info("AdminServiceImp - Admin has added successfull ");
		return admin;
	}


	@Override
	public Admin getAdminByEmail(String email) throws NoSuchAdminFoundException {
		Admin admin=repo.findByEmail(email).orElseThrow(()-> new NoSuchAdminFoundException("No such admin exists in database"));;
		logger.info("AdminServiceImp - Admin data fetched successfully");
		return new Admin(admin.getAdminId(),admin.getAdminName(),admin.getEmail(),admin.getPassword(),admin.getAdminProfilePic());
	}


	@Override
	public List<Admin> getAllAdmin() {
		return repo.findAll();
	}


	@Override
	public boolean deleteAdminById(long adminId) throws NoSuchAdminFoundException {
		repo.findById(adminId).orElseThrow(
				() -> new NoSuchAdminFoundException("No such admin exists in database"));
		repo.deleteById(adminId);
		Admin admin = repo.findById(adminId).orElse(null);
		logger.info("AdminServiceImp - Admin deleted successfully");
		return admin == null;
	}


	@Override
	public List<Admin> getAdminByName(String adminName) {
		return repo.findAdminByName(adminName);
	}


	@Override
	public Admin updateProfilePicture(long adminId, byte[] adminProfilePic) throws NoSuchAdminFoundException {
		Admin admin=repo.findById(adminId).orElseThrow(()->new NoSuchAdminFoundException("No such admin exists in database"));
		admin.setAdminProfilePic(adminProfilePic);
		return repo.save(admin);
	}


}
