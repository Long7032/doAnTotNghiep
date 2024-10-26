package com.example.demo.entity;

public class Token {
	private String email;
	private String roles;
	private String expired;
	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Token(String email, String roles, String expired) {
		super();
		this.email = email;
		this.roles = roles;
		this.expired = expired;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	@Override
	public String toString() {
		return "JWT [email=" + email + ", roles=" + roles + ", expired=" + expired + "]";
	}
	
	
}
