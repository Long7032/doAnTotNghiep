package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IDPromotionProduct;
import com.example.demo.entity.PromotionProduct;


public interface PromotionProductRepository extends JpaRepository<PromotionProduct, IDPromotionProduct>{

	//	Checking product has been exists in another promotion which status is active

    @Query(value = "SELECT * FROM public.promotion_products pp, jsonb_array_elements(pp.promotion_products_list_product) AS attr where attr->>'barcode'=?1 and pp.promotion_products_status = 'active'", nativeQuery = true)
	List<PromotionProduct> checkProductValid(String barcode);
	
	//	Update inactive status for the promotion has been expired
	
}
