package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


public class IDPromotionProduct implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private LocalDateTime timeCreate;
	private LocalDateTime timeEnd;
	public IDPromotionProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IDPromotionProduct(String name, LocalDateTime timeCreate, LocalDateTime timeEnd) {
		super();
		this.name = name;
		this.timeCreate = timeCreate;
		this.timeEnd = timeEnd;
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getTimeCreate() {
		return timeCreate;
	}
	public LocalDateTime getTimeEnd() {
		return timeEnd;
	}
	@Override
	public String toString() {
		return "IDPromotionProduct [name=" + name + ", timeCreate=" + timeCreate + ", timeEnd=" + timeEnd + "]";
	}
	
}
