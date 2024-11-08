package com.example.demo.entity;

import java.time.LocalDateTime;

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
	@Column(name = "employee_position")
	private String position;
	@Column(name = "employee_hired_date")
	private LocalDateTime hiredDate;

	@PrePersist
	public void onCreate() {
		if(hiredDate == null) {
			hiredDate = LocalDateTime.now();
		}
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String id, String position, LocalDateTime hiredDate) {
		super();
		this.id = id;
		this.position = position;
		this.hiredDate = hiredDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDateTime getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(LocalDateTime hiredDate) {
		this.hiredDate = hiredDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", position=" + position + ", hiredDate=" + hiredDate + "]";
	}

}
