package com.example.demo.entity;

public class AES {
	private String encrytText;

	public AES() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AES(String encrytText) {
		super();
		this.encrytText = encrytText;
	}

	public String getEncrytText() {
		return encrytText;
	}

	public void setEncrytText(String encrytText) {
		this.encrytText = encrytText;
	}

	@Override
	public String toString() {
		return "AES [encrytText=" + encrytText + "]";
	}
	
	
}
