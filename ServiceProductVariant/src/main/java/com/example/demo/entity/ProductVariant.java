package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@IdClass(IDProductVariant.class)
@Table(name = "product_variants", indexes = { 
		@Index(name = "idx_product_barcode", columnList = "product_variant_product_barcode"),
		@Index(name = "idx_size", columnList = "product_variant_size") 
})
public class ProductVariant {
	@Id
	@Column(name = "product_variant_product_barcode")
	private String productBarcode;
	@Id
	@Column(name = "product_variant_size")
	private String size;
	@Column(name = "product_variant_quantity")
	private int quantity;

	public ProductVariant(String barcode, String size, int quantity) {
		super();
		this.productBarcode = barcode;
		this.size = size;
		this.quantity = quantity;
	}

	public ProductVariant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public final String getProductBarcode() {
		return productBarcode;
	}

	public final void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}

	public final String getSize() {
		return size;
	}

	public final void setSize(String size) {
		this.size = size;
	}

	public final int getQuantity() {
		return quantity;
	}

	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductVariant [productBarcode=" + productBarcode + ", size=" + size + ", quantity=" + quantity + "]";
	}

}
