package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@IdClass(IDOrderStatus.class)
@Table(name="order-statuss", indexes = {
		@Index(name="idx_id_order", columnList = "order_status_id_order"),
		@Index(name="idx_time", columnList = "order_status_time")
})
public class OrderStatus {
	@Id
	@Column(name="order_status_id_order")
	private String idOrder;
	@Id
	@Column(name="order_status_status")
	private String status;
	@Column(name="order_status_time", nullable = false)
	private LocalDateTime time;
	@Column(name="order_status_id_user", nullable = false)
	private String idUser;
	@Column(name="order_status_note")
	private String note;
	public OrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderStatus(String idOrder, String status, LocalDateTime time, String idUser, String note) {
		super();
		this.idOrder = idOrder;
		this.status = status;
		this.time = time;
		this.idUser = idUser;
		this.note = note;
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
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "OrderStatus [idOrder=" + idOrder + ", status=" + status + ", time=" + time + ", idUser=" + idUser
				+ ", note=" + note + "]";
	}
	
	
}
