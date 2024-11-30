package com.example.demo.entity;

import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "product_barcode", nullable = false, unique = true)
	private String barcode; // Length: 13
	@Column(name = "product_name", nullable = false)
	private String name;
	@Column(name = "product_image_album", columnDefinition = "jsonb")
	@JdbcTypeCode(SqlTypes.JSON)
	private Set<String> imageAlbum;
	@Column(name = "product_gender")
	private String gender;
	@Column(name = "product_description", columnDefinition = "text")
	private String description;
	@Column(name = "product_price", nullable = false)
	private double price; // giá = giá gốc * ( 1 + thuế)
	@Column(name = "product_category_id", nullable = false)
	private String idCategory;
	@Column(name = "product_tax", nullable = false)
	private double tax;
	@Column(name = "product_status")
	private String status;

	@PrePersist
	protected void onCreate() {

		if (status == null) {
			status = "active";// Or Inactive
		}
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String barcode, String name, Set<String> imageAlbum, String gender, String description, double price,
			String idCategory, int tax, String status) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.imageAlbum = imageAlbum;
		this.gender = gender;
		this.description = description;
		this.price = price;
		this.idCategory = idCategory;
		this.tax = tax;

		this.status = status;
	}

	public Product(String name, Set<String> imageAlbum, String gender, String description, double price,
			String idCategory, int tax, String status) {
		super();
		this.name = name;
		this.imageAlbum = imageAlbum;
		this.gender = gender;
		this.description = description;
		this.price = price;
		this.idCategory = idCategory;
		this.tax = tax;

		this.status = status;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getImageAlbum() {
		return imageAlbum;
	}

	public void setImageAlbum(Set<String> imageAlbum) {
		this.imageAlbum = imageAlbum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [barcode=" + barcode + ", name=" + name + ", imageAlbum=" + imageAlbum + ", gender=" + gender
				+ ", description=" + description + ", price=" + price + ", idCategory=" + idCategory + ", tax=" + tax
				+ ", status=" + status + "]";
	}

}