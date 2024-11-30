package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PromotionProduct;
import com.example.demo.entity.PromotionProductDetail;
import com.example.demo.repository.PromotionProductRepository;

@Service
public class PromotionProductService {
	@Autowired
	private PromotionProductRepository promotionProductRepository;

	public int checkProductValid(String barcode) {
		System.out.println("Product Promotion Service - Check Product Promotion");
		int length = 0;
		try {
			List<PromotionProduct> rs = promotionProductRepository.checkProductValid(barcode);
			length = rs.toArray().length;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

//		System.out.println(length);
		return length;
	}

	public PromotionProduct savePromotionProduct(PromotionProduct promotionProduct) {
//		int numberOfProduct = promotionProduct.getListPromotionProduct().toArray().length;
		System.out.println("Product Promotion Service - Save Product Promotion");
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

	public PromotionProductDetail getProductByBarcode(String barcode) {
		System.out.println("Product Promotion Service - Get Product Promotion By Barcode");

		try {

			List<PromotionProduct> rs = promotionProductRepository.getProductPromotionByBarcode(barcode);
			System.out.println(rs.get(0).getListPromotionProduct());
			for (PromotionProductDetail ppd : rs.get(0).getListPromotionProduct()) {

				if (ppd.getBarcode().equals(barcode)) {
					return ppd;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return null;
	}

	public List<PromotionProduct> getProductPromotions() {
		System.out.println("Product Promotion Service - Get Product Promotions");

		return promotionProductRepository.findAll();
	}

	public void updateStatusInactive(LocalDateTime time) {
		// TODO Auto-generated method stub
		System.out.println("Product Promotion Service - Update Status Product Promotions Is Inactive");
		promotionProductRepository.updateStatusInactive(time);
	}
}
