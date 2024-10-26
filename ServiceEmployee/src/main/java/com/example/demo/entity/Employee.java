package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@Column(name = "employee_id")
	private String id; // NVyyyyMMddHHmmss
	@Column(name = "employee_avatar_url")
	private String avatar;
	@Column(name = "employee_name", nullable = false)
	private String name;
	@Column(name = "employee_gender", nullable = false)
	private String gender;
	@Column(name = "employee_birthday", nullable = false)
	private String birthday;
	@Column(name = "employee_email", nullable = false, unique = true)
	private String email;
	@Column(name = "employee_telephone", nullable = false, unique = true)
	private String telephone;
	@Column(name = "employee_address", columnDefinition = "jsonb")
	@JdbcTypeCode(SqlTypes.JSON)
	private HashMap<String, String> address;
	@Column(name = "employee_time_create")
	private LocalDateTime timeCreate;
	@Column(name = "employee_position")
	private String position;
	@Column(name = "employee_status")
	private String status;

	@PrePersist
	protected void onCreate() {
		if (status == null)
			status = "active";
		if (avatar == null)
			avatar = "https://cdn.kona-blue.com/upload/kona-blue_com/post/images/2024/09/18/457/avatar-mac-dinh-12.jpg";
		if (timeCreate == null) {
			timeCreate = LocalDateTime.now();
		}if (position == null)
			status = "staff";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String id, String avatar, String name, String gender, String birthday, String email,
			String telephone, HashMap<String, String> address, LocalDateTime timeCreate, String position,
			String status) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.timeCreate = timeCreate;
		this.position = position;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public HashMap<String, String> getAddress() {
		return address;
	}

	public void setAddress(HashMap<String, String> address) {
		this.address = address;
	}

	public LocalDateTime getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(LocalDateTime timeCreate) {
		this.timeCreate = timeCreate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", avatar=" + avatar + ", name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", email=" + email + ", telephone=" + telephone + ", address=" + address + ", timeCreate="
				+ timeCreate + ", position=" + position + ", status=" + status + "]";
	}

}
