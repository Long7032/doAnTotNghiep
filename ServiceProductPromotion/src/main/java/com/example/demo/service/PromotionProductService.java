package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PromotionProduct;
import com.example.demo.repository.PromotionProductRepository;

@Service
public class PromotionProductService {
	@Autowired
	private PromotionProductRepository promotionProductRepository;

	public int checkProductValid(String barcode) {
		List<PromotionProduct> rs = promotionProductRepository.checkProductValid(barcode);
		int length = rs.toArray().length;
//		System.out.println(length);
		return length;
	}

	public PromotionProduct savePromotionProduct(PromotionProduct promotionProduct) {
//		int numberOfProduct = promotionProduct.getListPromotionProduct().toArray().length;

		final int[] count = { 0 };
		promotionProduct.getListPromotionProduct().forEach(e -> {
			System.out.println(e);
			if (checkProductValid(e.getBarcode()) > 0) {
				count[0]++;
			}
		});
		System.out.println("The Number Of Invalid Product: " + String.valueOf(count[0]));
		if (count[0] == 0) {
			
			return promotionProductRepository.save(promotionProduct);
		}
		return null;
	}
}
