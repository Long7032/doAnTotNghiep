package com.example.demo.entity;

public class Token {
	private String id;
	private String roles;
	private String expired;
	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Token(String id, String roles, String expired) {
		super();
		this.id = id;
		this.roles = roles;
		this.expired = expired;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
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
		return "Token [id=" + id + ", roles=" + roles + ", expired=" + expired + "]";
	}

	
	
}
