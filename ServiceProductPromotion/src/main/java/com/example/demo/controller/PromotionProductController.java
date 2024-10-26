package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PromotionProduct;
import com.example.demo.service.PromotionProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/promotion-products")
public class PromotionProductController {
	@Autowired
	private PromotionProductService promotionProductService;

	@PostMapping("/")
	public ResponseEntity<Object> savePromotionProduct(@RequestBody PromotionProduct promotionProduct) {
		//TODO: process POST request
//		promotionProductService.checkProductValid("");
		PromotionProduct rs = promotionProductService.savePromotionProduct(promotionProduct);
		System.out.println(rs);
		if(rs == null) {
			return ResponseEntity.status(409).body(new String("fail"));
		}
		return ResponseEntity.status(200).body(new String("success"));
	}
	
}
