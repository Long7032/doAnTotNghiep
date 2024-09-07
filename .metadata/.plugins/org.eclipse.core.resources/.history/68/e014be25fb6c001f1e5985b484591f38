package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	private int id;
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	@Column(nullable = false)
	private String password;
	@Column(name = "id_user", nullable = false)
	private int idUser;
	private String role;

	@PrePersist
	protected void onCreate() {
		if (role == null)
			role = "customer";
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String userName, String password, int idUser) {
		super();
		this.userName = userName;
		this.password = password;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", userName=" + userName + ", password=" + password + ", idUser=" + idUser
				+ ", role=" + role + "]";
	}

}
