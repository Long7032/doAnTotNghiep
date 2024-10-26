package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "user_id")
	private String id;
	@Column(name = "user_avatar_url")
	private String avatar;
	@Column(name = "user_name", nullable = false)
	private String name;
	@Column(name = "user_phone_number", unique = true)
	private String phone;
	@Column(name = "user_email", unique = true, nullable = false)
	private String email;
	@Column(name = "user_gender")
	private String gender;
	@Column(name = "user_birthday")
	private LocalDateTime birthday;
	@Column(name = "user_time_create")
	private LocalDateTime timeCreate;
	@Column(name = "user_shopping_point")
	private double shoppingPoint;
	@Column(name = "user_role", nullable = false)
	private String role;

	@PrePersist
	protected void onCreate() {
		if (avatar == null) {
			avatar = "https://cdn.kona-blue.com/upload/kona-blue_com/post/images/2024/09/18/457/avatar-mac-dinh-12.jpg";
		}
		if (shoppingPoint == 0) {
			shoppingPoint = 0;
		}
		if (timeCreate == null) {
			timeCreate = LocalDateTime.now();
		}
		if (role == null) {
			role = "2";		// 2 is customer and 1 is employee
		}
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String avatar, String name, String phone, String email, String gender, LocalDateTime birthday,
			LocalDateTime timeCreate, double shoppingPoint, String status) {
		super();
		this.avatar = avatar;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.timeCreate = timeCreate;
		this.shoppingPoint = shoppingPoint;
		this.role = status;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getAvatar() {
		return avatar;
	}

	public final void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getGender() {
		return gender;
	}

	public final void setGender(String gender) {
		this.gender = gender;
	}

	public final LocalDateTime getBirthday() {
		return birthday;
	}

	public final void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public final LocalDateTime getTimeCreate() {
		return timeCreate;
	}

	public final void setTimeCreate(LocalDateTime timeCreate) {
		this.timeCreate = timeCreate;
	}

	public final double getShoppingPoint() {
		return shoppingPoint;
	}

	public final void setShoppingPoint(double shoppingPoint) {
		this.shoppingPoint = shoppingPoint;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", avatar=" + avatar + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", gender=" + gender + ", birthday=" + birthday + ", timeCreate=" + timeCreate + ", shoppingPoint="
				+ shoppingPoint + ", role=" + role + "]";
	}



}
