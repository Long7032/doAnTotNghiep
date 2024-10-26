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
		ProductVariant rs = productVariantRepository.save(productVariant);
		return rs;
	}
	

	public List<ProductVariant> getProductVariants() {
		return productVariantRepository.findAll();
	}
	
	public List<ProductVariant> getProductVariant(ProductVariant productVariant) {
		List<ProductVariant> rs = productVariantRepository.getProductVariantByBarcode(productVariant.getProductBarcode());
		return rs;
	}
	
	@SuppressWarnings("deprecation")
	public ProductVariant updateQuantiyProductVariant(ProductVariant productVariant, String type) {
		IDProductVariant id = new IDProductVariant(productVariant.getProductBarcode(), productVariant.getSize());
		ProductVariant rs = productVariantRepository.getById(id);
		if(type.equals("increase")) {
			int newQuantity = rs.getQuantity() + productVariant.getQuantity();
			rs.setQuantity(newQuantity);
		} else if(type.equals("decrease")) {
			int newQuantity = rs.getQuantity() - productVariant.getQuantity();
			rs.setQuantity(newQuantity);
		}
		return productVariantRepository.saveAndFlush(rs);
	}
}
