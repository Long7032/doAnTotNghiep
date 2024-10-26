package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders", indexes = { 
		@Index(name = "idx_order_id_user", columnList = "order_id_user"),
		@Index(name = "idx_order_id", columnList = "order_id") })
@IdClass(IDOrder.class)
public class Order {
	@Id
	@Column(name = "order_id")
	private String idOrder;
	@Column(name = "order_date_time", nullable = false)
	private LocalDateTime dateTime;
	@Column(name = "order_order_status_current_status", nullable = false)
	private String currentStatus;
	@Column(name = "order_payment_method", nullable = false)
	private String paymentMethod;
	@Column(name = "order_address", columnDefinition = "jsonb")
	@JdbcTypeCode(SqlTypes.JSON)
	private Map<String, String> address;
	@Id
	@Column(name = "order_id_user")
	private String idUser;

	@PrePersist
	protected void onCreate() {
		if (currentStatus == null) {
			currentStatus = "create";
		}
		if (dateTime == null) {
			dateTime = LocalDateTime.now();
		}
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(String idOrder, LocalDateTime dateTime, String currentStatus, String paymentMethod,
			Map<String, String> address, String idUser) {
		super();
		this.idOrder = idOrder;
		this.dateTime = dateTime;
		this.currentStatus = currentStatus;
		this.paymentMethod = paymentMethod;
		this.address = address;
		this.idUser = idUser;
	}

	public final String getIdOrder() {
		return idOrder;
	}

	public final void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public final LocalDateTime getDateTime() {
		return dateTime;
	}

	public final void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public final String getCurrentStatus() {
		return currentStatus;
	}

	public final void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public final String getPaymentMethod() {
		return paymentMethod;
	}

	public final void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public final Map<String, String> getAddress() {
		return address;
	}

	public final void setAddress(Map<String, String> address) {
		this.address = address;
	}

	public final String getIdUser() {
		return idUser;
	}

	public final void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", dateTime=" + dateTime + ", currentStatus=" + currentStatus
				+ ", paymentMethod=" + paymentMethod + ", address=" + address + ", idUser=" + idUser + "]";
	}

}
