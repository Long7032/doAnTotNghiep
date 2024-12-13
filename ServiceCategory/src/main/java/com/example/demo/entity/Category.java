package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "category_id")
	private String id;
	@Column(name = "category_image")
	private String image;
	@Column(name = "category_name", nullable = false, unique = true)
	private String name;
	@Column(name = "category_status")
	private String status;

	@PrePersist
	protected void onCreate() {
		if (status == null) {
			status = "active";
		}
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String id, String image, String name, String status) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", image=" + image + ", name=" + name + ", status=" + status + "]";
	}

}
