package com.example.demo.entity;

import java.io.Serializable;

public class IDOrderStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idOrder;
	private String status;

	public IDOrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IDOrderStatus(String idOrder, String status) {
		super();
		this.idOrder = idOrder;
		this.status = status;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "IDOrderStatus [idOrder=" + idOrder + ", status=" + status + "]";
	}

}
