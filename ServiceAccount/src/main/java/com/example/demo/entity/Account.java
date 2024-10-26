package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Column(name = "account_user_name", nullable = false, unique = true)
	private String userName;
	@Column(name = "account_password", nullable = false)
	private String password;
	@Id
	@Column(name = "user_id", nullable = false)
	private String idUser;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String userName, String password, String idUser) {
		super();
		this.userName = userName;
		this.password = password;
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password + ", idUser=" + idUser + "]";
	}

}
