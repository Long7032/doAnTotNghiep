package com.example.demo.entity;

import java.time.LocalDateTime;

public class CartItem {
	private String idProduct;
	private String sizeProduct;
	private String quantity;
	private LocalDateTime timeCreate;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(String idProduct, String sizeProduct, String quantity, LocalDateTime timeCreate) {
		super();
		this.idProduct = idProduct;
		this.sizeProduct = sizeProduct;
		this.quantity = quantity;
		this.timeCreate = timeCreate;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getSizeProduct() {
		return sizeProduct;
	}

	public void setSizeProduct(String sizeProduct) {
		this.sizeProduct = sizeProduct;
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
		return "CartItem [idProduct=" + idProduct + ", sizeProduct=" + sizeProduct + ", quantity=" + quantity
				+ ", timeCreate=" + timeCreate + "]";
	}

}
