package com.example.demo.entity;

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
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private String id; // yyyyMMddHHmmss
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
	@Column(name = "address", columnDefinition = "jsonb")
	@JdbcTypeCode(SqlTypes.JSON)
	private HashMap<String, String> address;
	@Column(name = "status_employee")
	private String status;

	@PrePersist
	protected void onCreate() {
		if (status == null)
			status = "active";
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String id, String name, String gender, String birtday, String email, String telephone,
			HashMap<String, String> address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birtday;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", email="
				+ email + ", telephone=" + telephone + ", address=" + address + ", status=" + status + "]";
	}



}
