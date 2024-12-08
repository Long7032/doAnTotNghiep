package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.IDPromotionProduct;
import com.example.demo.entity.PromotionProduct;
import com.example.demo.entity.PromotionProductDetail;
import com.example.demo.service.PromotionProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		System.out.println("Promotion Product Controller - Save Product Promotion");

		try {
			PromotionProduct rs = promotionProductService.savePromotionProduct(promotionProduct);
			System.out.println(rs);

			if (rs == null) {
				return ResponseEntity.status(409).body("fail");
			}

			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while saving promotion product: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@GetMapping("/barcode/{barcode}")
	public ResponseEntity<Object> getProductPromotionByBarcode(@PathVariable String barcode) {
		System.out.println("Promotion Product Controller - Get Product Promotion By Barcode");

		try {
			PromotionProductDetail rs = promotionProductService.getProductByBarcode(barcode);
			if (rs == null) {
				return ResponseEntity.status(409).body("fail");
			}
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("Error occurred while fetching product promotion by barcode: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@GetMapping("/")
	public ResponseEntity<Object> getProductPromotions() {
		System.out.println("Promotion Product Controller - Get Product Promotions");

		try {
			List<PromotionProduct> rs = promotionProductService.getProductPromotions();
			if (rs == null || rs.isEmpty()) {
				return ResponseEntity.status(409).body("fail");
			}
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("Error occurred while fetching product promotions: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@GetMapping("/{type}/{page}/{size}")
	public ResponseEntity<Object> getProductPromotionsByTypeInRange(@PathVariable String type, @PathVariable int page,
			@PathVariable int size) {
		System.out.println("Promotion Product Controller - Get Product Promotions By Type Range");
		try {
			List<PromotionProduct> rs = promotionProductService.getProductPromotionsByTypeInRange(type, page, size);
			if (rs == null || rs.isEmpty()) {
				return ResponseEntity.status(409).body("fail");
			}
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("Error occurred while fetching product promotions: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@GetMapping("/name/{type}/{name}/{page}/{size}")
	public ResponseEntity<Object> getUsersByName(@PathVariable String type, @PathVariable String name,
			@PathVariable int page, @PathVariable int size) {
		System.out.println("Product Promotion Controller - Get Promotion By Name And Status");

		try {
			List<PromotionProduct> users = promotionProductService.getPromotionByNameAndStatusInRange(name, type, page,
					size);
			if (users != null && !users.isEmpty()) {
				return ResponseEntity.status(200).body(users);
			} else {
				return ResponseEntity.status(404).body("Promotion Not Found");
			}
		} catch (Exception e) {
			System.err.println("Error occurred while getting users by name: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@PostMapping("/id")
	public ResponseEntity<Object> getPromotionByID(@RequestBody IDPromotionProduct idPromotionProduct) {
		System.out.println("Promotion Controller - Get Promotion By ID");

		try {
			PromotionProduct promotionProduct = promotionProductService.getPromotionByID(idPromotionProduct);
			return ResponseEntity.status(200).body(promotionProduct);
		} catch (Exception e) {
			System.err.println("An error occurred while fetching promotion by ID: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@PutMapping("/")
	public ResponseEntity<Object> updatePromotionByID(@RequestBody PromotionProduct promotionProduct) {
		// TODO: process PUT request
		System.out.println("Promotion Controller - Update Promotion By ID");

		try {
			PromotionProduct rs = promotionProductService.updatePromotionByID(promotionProduct);
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while fetching promotion by ID: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

}
