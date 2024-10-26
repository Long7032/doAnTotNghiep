package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@IdClass(IDOrderDetail.class)
@Table(name = "order_details", indexes = { 
		@Index(name = "idx_id_order", columnList = "order_detail_id_order"),
		@Index(name = "idx_id_product", columnList = "order_detail_id_product") })

public class OrderDetail {
	@Id
	@Column(name = "order_detail_id_order")
	private String idOrder;
	@Id
	@Column(name = "order_detail_id_product")
	private String idProduct;
	@Column(name = "order_detail_quantity_product")
	private int quantity;
	@Column(name = "order_detail_price_product")
	private double price;
	@Column(name = "order_detail_price_promotion")
	private double pricePromotion;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(String idOrder, String idProduct, int quantity, double price, double pricePromotion) {
		super();
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
		this.pricePromotion = pricePromotion;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPricePromotion() {
		return pricePromotion;
	}

	public void setPricePromotion(double pricePromotion) {
		this.pricePromotion = pricePromotion;
	}

	@Override
	public String toString() {
		return "OrderDetail [idOrder=" + idOrder + ", idProduct=" + idProduct + ", quantity=" + quantity + ", price="
				+ price + ", pricePromotion=" + pricePromotion + "]";
	}

}
