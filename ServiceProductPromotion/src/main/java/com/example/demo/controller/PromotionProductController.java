package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PromotionProduct;
import com.example.demo.entity.PromotionProductDetail;
import com.example.demo.service.PromotionProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/promotion-products")
public class PromotionProductController {
	@Autowired
	private PromotionProductService promotionProductService;

	@PostMapping("/")
	public ResponseEntity<Object> savePromotionProduct(@RequestBody PromotionProduct promotionProduct) {
		// TODO: process POST request
//		promotionProductService.checkProductValid("");

		System.out.println("Promotion Product Controller - Save Product Promotion");

		PromotionProduct rs = promotionProductService.savePromotionProduct(promotionProduct);
		System.out.println(rs);
		if (rs == null) {
			return ResponseEntity.status(409).body(new String("fail"));
		}
		return ResponseEntity.status(200).body(rs);
	}

	@GetMapping("/barcode/{barcode}")
	public ResponseEntity<Object> getProductPromotionByBarcode(@PathVariable String barcode) {
		System.out.println("Promotion Product Controller - Get Product Promotion By Barcode");

		PromotionProductDetail rs = promotionProductService.getProductByBarcode(barcode);
		if (rs == null) {
			return ResponseEntity.status(409).body(new String("fail"));
		}
		return ResponseEntity.status(200).body(rs);
	}
	@GetMapping("/")
	public ResponseEntity<Object> getProductPromotions() {
		System.out.println("Promotion Product Controller - Get Product Promotions");

		List<PromotionProduct> rs = promotionProductService.getProductPromotions();
		if (rs == null) {
			return ResponseEntity.status(409).body(new String("fail"));
		}
		return ResponseEntity.status(200).body(rs);
	}

}
