package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IDProductVariant;
import com.example.demo.entity.ProductVariant;
import com.example.demo.repository.ProductVariantRepository;

@Service
public class ProductVariantService {
	@Autowired
	private ProductVariantRepository productVariantRepository;

	public ProductVariant saveProductVariant(ProductVariant productVariant) {
		System.out.println("Product Variant Service - Save Product Variant");
		ProductVariant rs = productVariantRepository.save(productVariant);
		return rs;
	}

	public boolean checkQuantityOfProductVariant(ProductVariant productVariant) {
		System.out.println("Product Variant Service - Check Quantity Of Product Variant");
		ProductVariant rs = productVariantRepository
				.findById(new IDProductVariant(productVariant.getProductBarcode(), productVariant.getSize()))
				.orElseThrow();
		if (productVariant.getQuantity() <= rs.getQuantity()) {
			System.out.println("Valid Quantity");
			return true;
		}
		return false;
	}

	public List<ProductVariant> getProductVariants() {
		return productVariantRepository.findAll();
	}

	public List<ProductVariant> getProductVariant(ProductVariant productVariant) {
		List<ProductVariant> rs = productVariantRepository
				.getProductVariantByBarcode(productVariant.getProductBarcode());
		return rs;
	}

	public ProductVariant updateQuantiyProductVariant(ProductVariant productVariant, String type) {
		IDProductVariant id = new IDProductVariant(productVariant.getProductBarcode(), productVariant.getSize());
		ProductVariant rs = productVariantRepository.findById(id).orElseThrow();
		if (type.equals("increase")) {
			int newQuantity = rs.getQuantity() + productVariant.getQuantity();
			rs.setQuantity(newQuantity);
		} else if (type.equals("decrease")) {
			int newQuantity = rs.getQuantity() - productVariant.getQuantity();
			rs.setQuantity(newQuantity);
		}
		return productVariantRepository.saveAndFlush(rs);
	}
}
