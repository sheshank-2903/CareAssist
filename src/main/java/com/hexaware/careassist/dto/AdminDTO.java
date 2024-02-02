package com.hexaware.careassist.dto;

public class AdminDTO {
	
	
	private long adminId;
	
	private String name;
	
	
	private String email;
	
	private String password;
	
	
	
	public AdminDTO() {
		super();
	}
	
	public AdminDTO(long adminId, String name) {
		super();
		this.adminId = adminId;
		this.name = name;
	}
	
	public long getId() {
		return adminId;
	}
	public void setId(long adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
