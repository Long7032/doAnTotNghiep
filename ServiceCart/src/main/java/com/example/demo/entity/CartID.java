package com.example.demo.entity;

import java.io.Serializable;

public class CartID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1089915906733949340L;
	private String id;
	private String idUser;

	public CartID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartID(String id, String idUser) {
		super();
		this.id = id;
		this.idUser = idUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "CartID [id=" + id + ", idUser=" + idUser + "]";
	}

}
