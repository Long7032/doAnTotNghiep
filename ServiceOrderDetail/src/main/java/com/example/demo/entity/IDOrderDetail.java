package com.example.demo.entity;

import java.io.Serializable;

public class IDOrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idOrder;
	private String idProduct;
	public IDOrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IDOrderDetail(String idOrder, String idProduct) {
		super();
		this.idOrder = idOrder;
		this.idProduct = idProduct;
	}
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	@Override
	public String toString() {
		return "IDOrderDetail [idOrder=" + idOrder + ", idProduct=" + idProduct + "]";
	}
	
}
