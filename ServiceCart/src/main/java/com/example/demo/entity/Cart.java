package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
@IdClass(CartID.class)
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "cart_id")
	private String id;
	@Id
	@Column(name = "cart_user_id", unique = true)
	private String idUser;
	@Column(name = "cart_time_created")
	private LocalDateTime timeCreated; // Time Created New Cart
	@Column(name = "cart_time_updated")
	private LocalDateTime timeUpdated; // Time Update New Data
	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name = "cart_list_cart_items")
	private Set<CartItem> listCartItem;

	@PrePersist
	public void onCreate() {
		if (timeCreated == null) {
			timeCreated = LocalDateTime.now();
		}
		if (timeUpdated == null) {
			timeUpdated = LocalDateTime.now();
		}
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String idUser) {
		super();
		this.idUser = idUser;
	}

	public Cart(String id, String idUser, LocalDateTime timeCreated, LocalDateTime timeUpdated,
			Set<CartItem> listCartItem) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.timeCreated = timeCreated;
		this.timeUpdated = timeUpdated;
		this.listCartItem = listCartItem;
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

	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}

	public LocalDateTime getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(LocalDateTime timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public Set<CartItem> getListCartItem() {
		return listCartItem;
	}

	public void setListCartItem(Set<CartItem> listCartItem) {
		this.listCartItem = listCartItem;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", idUser=" + idUser + ", timeCreated=" + timeCreated + ", timeUpdated=" + timeUpdated
				+ ", listCartItem=" + listCartItem + "]";
	}

}
