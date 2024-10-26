package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IDProductVariant;
import com.example.demo.entity.ProductVariant;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, IDProductVariant>{
	@Query("select pv from ProductVariant pv where pv.productBarcode = ?1")
	public List<ProductVariant> getProductVariantByBarcode(String barcode);
}
