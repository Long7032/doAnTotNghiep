package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

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
@Table(name="promotion_products", indexes = {
		@Index(name="idx_time_create",columnList = "promotion_products_time_create"),
		@Index(name="idx_time_end",columnList = "promotion_products_time_end"),
		@Index(name="idx_promotion_name",columnList = "promotion_products_name"),
})
@IdClass(IDPromotionProduct.class)
public class PromotionProduct {
	@Id
	@Column(name = "promotion_products_name", nullable = false)
	private String name;
	@Column(name = "promotion_products_description")
	private String description;
	@Id
	@Column(name = "promotion_products_time_create")
	private LocalDateTime timeCreate;
	@Id
	@Column(name = "promotion_products_time_end")
	private LocalDateTime timeEnd;
	@Column(name = "promotion_products_list_product", columnDefinition = "jsonb")
	@JdbcTypeCode(SqlTypes.JSON)
	private Set<PromotionProductDetail> listPromotionProduct;
	@Column(name = "promotion_products_status", nullable = false)
	private String status;
	@PrePersist
	protected void onCreate() {
		if (status == null)
			status = "active";
	}
	public PromotionProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PromotionProduct(String name, String description, LocalDateTime timeCreate, LocalDateTime timeEnd,
			Set<PromotionProductDetail> listPromotionProduct, String status) {
		super();
		this.name = name;
		this.description = description;
		this.timeCreate = timeCreate;
		this.timeEnd = timeEnd;
		this.listPromotionProduct = listPromotionProduct;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(LocalDateTime timeCreate) {
		this.timeCreate = timeCreate;
	}
	public LocalDateTime getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(LocalDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Set<PromotionProductDetail> getListPromotionProduct() {
		return listPromotionProduct;
	}
	public void setListPromotionProduct(Set<PromotionProductDetail> listPromotionProduct) {
		this.listPromotionProduct = listPromotionProduct;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProductPromotion [name=" + name + ", description=" + description + ", timeCreate=" + timeCreate
				+ ", timeEnd=" + timeEnd + ", listPromotionProduct=" + listPromotionProduct + ", status=" + status
				+ "]";
	}	
}
