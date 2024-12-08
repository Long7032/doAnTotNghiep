package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	// ========== Get Products ==========
	@GetMapping("/")
	public ResponseEntity<Object> getProducts() {
		try {
			List<Product> products = productService.getProducts();
			return ResponseEntity.status(200).body(products);
		} catch (Exception e) {
			System.err.println("Error occurred while getting products: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}
	@GetMapping("/{page}/{size}")
	public ResponseEntity<Object> getProductsInRange(@PathVariable int page, @PathVariable int size) {
		try {
			List<Product> rs = productService.getProductInRange(page, size);

			if (rs.isEmpty()) {
				return ResponseEntity.status(409).body("No products found in the specified range.");
			}

			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("Error occurred while getting products in range: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	// ========== Get Product By Bar Code ==========
	@PostMapping("/barcode")
	public ResponseEntity<Object> getProductsBarcode(@RequestBody Product product) {
		System.out.println("Product Controller - Get Products By Barcode");
		return ResponseEntity.status(200).body(productService.getProduct(product));
	}

	// ========== Get Products By Category ==========
	@PostMapping("/category-length")
	public ResponseEntity<Object> getProductsByIdCategory(@RequestBody Product product) {
		return ResponseEntity.status(200)
				.body(productService.getProductsByCategory(product.getIdCategory()).toArray().length);
	}

	@PostMapping("/category/{page}/{size}")
	public ResponseEntity<Object> getProductsByIdCategoryInRange(@RequestBody Product product, @PathVariable int page,
			@PathVariable int size) {
		return ResponseEntity.status(200)
				.body(productService.getProductsByCategoryInRange(product.getIdCategory(), page, size));
	}

	// ========== Get Products By Name ==========
	@GetMapping("/{name}")
	public ResponseEntity<Object> getProductsByName(@PathVariable String name) {
		try {
			List<Product> rs = productService.getProductsByName(name);

			if (rs.isEmpty()) {
				return ResponseEntity.status(409).body("No products found with the name: " + name);
			}

			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("Error occurred while getting products by name: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	// ========== Save Product ==========
	@PostMapping("/")
	public ResponseEntity<Object> saveProducts(@RequestBody Product product) {
		System.out.println("Product: " + product);
		Product p = productService.saveProduct(product);
		if (p == null) {
			return ResponseEntity.status(409).body(new String("Product has been exists"));
		}
		return ResponseEntity.status(200).body(p);
	}

	// ========== Testing Product ==========
	@PostMapping("/testing-data")
	public ResponseEntity<Object> saveTestingProducts(@RequestBody List<Product> products) {
		System.out.println("Product Controller - Testing Product");
		products.forEach(e -> {
			productService.saveProduct(e);
		});

		return ResponseEntity.status(200).body(productService.getProducts());
	}
}
