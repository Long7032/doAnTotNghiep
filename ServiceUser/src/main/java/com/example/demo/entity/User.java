package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "avatar_url_user")
	private String avatar;
	@Column(name = "name_user", nullable = false)
	private String name;
	@Column(name = "phone_number_user", unique = true)
	private String phone;
	@Column(name = "email_user", unique = true, nullable = false)
	private String email;
	private String gender;
	private String birthday;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String avatar, String name, String phone, String email, String gender, String birthday) {
		super();
		this.avatar = avatar;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", avatar=" + avatar + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", gender=" + gender + ", birthday=" + birthday + "]";
	}

}
