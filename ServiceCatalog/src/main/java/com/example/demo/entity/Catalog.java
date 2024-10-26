package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogs", indexes = { @Index(name = "idx_name", columnList = "catalog_name") })
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "catalog_id")
	private String id;
	@Column(name = "catalog_name", unique = true, nullable = false)
	private String name;
	@Column(name = "catalog_status")
	private String status;

	@PrePersist
	protected void onCreate() {

		if (status == null) {
			status = "active";
		}
	}

	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catalog(String id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Catalog [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

}
