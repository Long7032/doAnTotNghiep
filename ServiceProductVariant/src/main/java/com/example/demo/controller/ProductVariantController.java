package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductVariant;
import com.example.demo.service.ProductVariantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {
	@Autowired
	private ProductVariantService productVariantService;

	@GetMapping("/")
	public List<ProductVariant> getProductVariants() {
		return productVariantService.getProductVariants();
	}

	@PostMapping("/barcode")
	public List<ProductVariant> getProductVariant(@RequestBody ProductVariant productVariant) {

		return productVariantService.getProductVariant(productVariant);
	}

	@PostMapping("/")
	public ProductVariant saveProductVariant(@RequestBody ProductVariant productVariant) {
		return productVariantService.saveProductVariant(productVariant);
	}

	@PutMapping("/increase")
	public ProductVariant increaseQuantityProductVariant(@RequestBody ProductVariant productVariant) {
		return productVariantService.updateQuantiyProductVariant(productVariant, "increase");
	}

	@PutMapping("/decrease")
	public ProductVariant decreaseProductVariant(@RequestBody ProductVariant productVariant) {
		System.out.println("Product Variants - Update Quantity - Descrease");
		return productVariantService.updateQuantiyProductVariant(productVariant, "decrease");
	}

	@PostMapping("/check-quantity")
	public ResponseEntity<Object> checkQuantityOfProductVariant(@RequestBody ProductVariant productVariant) {
		System.out.println("Product Variant Controller - Check Quantity Of Product Variant");

		boolean rs = productVariantService.checkQuantityOfProductVariant(productVariant);
		if (rs == true) {
			return ResponseEntity.status(200).body(new String("Valid Quantity"));
		}
		return ResponseEntity.status(400).body(new String("Invalid Quantity"));
	}

}
