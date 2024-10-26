package com.example.demo.entity;

import java.time.LocalDateTime;

public class CartItem {
	private String idProduct;
	private String quantity;
	private LocalDateTime timeCreate;

	public CartItem(String idProduct, String quantity, LocalDateTime timeCreate) {
		super();
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.timeCreate = timeCreate;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(LocalDateTime timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Override
	public String toString() {
		return "CartItem [idProduct=" + idProduct + ", quantity=" + quantity + ", timeCreate=" + timeCreate + "]";
	}

}
