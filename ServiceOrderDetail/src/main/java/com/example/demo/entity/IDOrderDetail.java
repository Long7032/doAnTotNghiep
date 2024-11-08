package com.example.demo.entity;

import java.io.Serializable;

public class IDOrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idOrder;
	private String idProduct;
	private String sizeProduct;

	public IDOrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IDOrderDetail(String idOrder, String idProduct, String sizeProduct) {
		super();
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.sizeProduct = sizeProduct;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public String getSizeProduct() {
		return sizeProduct;
	}

	@Override
	public String toString() {
		return "IDOrderDetail [idOrder=" + idOrder + ", idProduct=" + idProduct + ", sizeProduct=" + sizeProduct + "]";
	}

}
