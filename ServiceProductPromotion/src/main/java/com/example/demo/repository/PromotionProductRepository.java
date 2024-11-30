package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IDPromotionProduct;
import com.example.demo.entity.PromotionProduct;

import jakarta.transaction.Transactional;

public interface PromotionProductRepository extends JpaRepository<PromotionProduct, IDPromotionProduct> {

	// Checking product has been exists in another promotion which status is active
	@Query(value = "SELECT * FROM public.promotion_products pp, jsonb_array_elements(pp.promotion_products_list_product) AS attr where attr->>'barcode'=?1 and pp.promotion_products_status = 'active'", nativeQuery = true)
	List<PromotionProduct> checkProductValid(String barcode);

	// Get Product In Product Promotion
	@Query(value = "SELECT * FROM public.promotion_products pp, jsonb_array_elements(pp.promotion_products_list_product) AS attr where attr->>'barcode'=?1 and pp.promotion_products_status = 'active'", nativeQuery = true)
	List<PromotionProduct> getProductPromotionByBarcode(String barcode);

	// Update inactive status for the promotion has been expired

	@Modifying
	@Transactional
	@Query("UPDATE PromotionProduct pp SET pp.status = 'inactive' WHERE pp.timeEnd <= ?1")
	void updateStatusInactive(LocalDateTime now);
}
