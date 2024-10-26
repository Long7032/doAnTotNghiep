package com.example.demo.entity;

import java.io.Serializable;

public class IDOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idOrder;
	private String idUser;
	public IDOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IDOrder(String idOrder, String idUser) {
		super();
		this.idOrder = idOrder;
		this.idUser = idUser;
	}
	public final String getIdOrder() {
		return idOrder;
	}
	public final void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public final String getIdUser() {
		return idUser;
	}
	public final void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "IDOrder [idOrder=" + idOrder + ", idUser=" + idUser + "]";
	}
	
	
}
