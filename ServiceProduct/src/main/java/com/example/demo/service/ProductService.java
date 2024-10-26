package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	public ProductRepository productRepository;

	// Save Product Into DB
	public Product saveProduct(Product product) {
		Product p = null;
		try {
			p = productRepository.save(product);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Service Product - Save Product: " + e);
			return null;
		}
		return p;
	}

	// Delete Product By Bar Code
	public Product deleteProduct(Product product) {
		Product rs = productRepository.getById(product.getBarcode());
		productRepository.delete(rs);
		return null;
	}

	// Update Product By Bar Code
	public Product updateProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}

	// Get All Product
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	// Get Product By Page And Size
	public List<Product> getProductInRange(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return productRepository.getProductInRange(pageable);
	}

	// Get Product By Name
	public List<Product> getProductsByName(String name) {
		return productRepository.getProductByName(name);
	}

	// Get Product By Category
	public List<Product> getProductsByCategory(int id) {
		System.out.println("Product Service - Get Product By Category");
		System.out.println("Data Init: " + id);
		List<Product> rs = productRepository.getProductByCategory(id);
		System.out.println("Data Result" + rs);
		return rs;
	}

	// Get Product By Bar code
	public Product getProduct(Product product) {
		return productRepository.getProductByBarcode(product.getBarcode());
	}	
}
