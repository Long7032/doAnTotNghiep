/**
 * 
 */
package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "otps")
public class OTP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_otp")
	private int id;
	@Column(name = "email_user", unique = true)
	private String emailUser;
	@Column(unique = true)
	private String message;
	@Column(name = "time_create")
	private LocalDateTime timeCreate;
	@Column(name = "time_end")
	private LocalDateTime timeEnd;

	public OTP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OTP(int id, String emailUser, String message, LocalDateTime timeCreate, LocalDateTime timeEnd) {
		super();
		this.id = id;
		this.emailUser = emailUser;
		this.message = message;
		this.timeCreate = timeCreate;
		this.timeEnd = timeEnd;
	}

	public OTP(String emailUser, String message, LocalDateTime timeCreate, LocalDateTime timeEnd) {
		super();
		this.emailUser = emailUser;
		this.message = message;
		this.timeCreate = timeCreate;
		this.timeEnd = timeEnd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(LocalDateTime timeCreate) {
		this.timeCreate = timeCreate;
	}

	public LocalDateTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Override
	public String toString() {
		return "OTP [id=" + id + ", emailUser=" + emailUser + ", message=" + message + ", timeCreate=" + timeCreate
				+ ", timeEnd=" + timeEnd + "]";
	}

}
