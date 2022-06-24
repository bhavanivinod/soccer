package com.htc.SoccerApp.model;

import java.util.List;

import com.htc.SoccerApp.util.JwtUtil;

public class AuthResponse {
	
	private String jwtUtil;
	private String username;
	private List<String> roles;
	public AuthResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthResponse(String jwtUtil, String username, List<String> roles) {
		super();
		this.jwtUtil = jwtUtil;
		this.username = username;
		this.roles = roles;
	}

	public String getJwtUtil() {
		return jwtUtil;
	}
	public void setJwtUtil(String jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	

}
