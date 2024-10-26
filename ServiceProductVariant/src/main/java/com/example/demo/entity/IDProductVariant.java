package com.example.demo.entity;

import java.io.Serializable;

public class IDProductVariant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productBarcode;
	private String size;
	public IDProductVariant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IDProductVariant(String productBarcode, String size) {
		super();
		this.productBarcode = productBarcode;
		this.size = size;
	}
	public String getProductBarcode() {
		return productBarcode;
	}
	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "IDProductVariant [productBarcode=" + productBarcode + ", size=" + size + "]";
	}
	
	
}
