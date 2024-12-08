package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IDPromotionProduct;
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
			length = rs.size(); // Sử dụng size() thay vì toArray().length
		} catch (Exception e) {
			// Ghi lại lỗi
			System.err.println("An error occurred while checking product validity: " + e.getMessage());
		}

		return length;
	}

	public PromotionProduct savePromotionProduct(PromotionProduct promotionProduct) {
		System.out.println("Product Promotion Service - Save Product Promotion");
		final int[] count = { 0 };

		try {
			promotionProduct.getListPromotionProduct().forEach(e -> {
				System.out.println(e);
				if (checkProductValid(e.getBarcode()) > 0) {
					count[0]++;
				}
			});

			System.out.println("The Number Of Invalid Product: " + count[0]);

			if (count[0] == 0) {
				return promotionProductRepository.save(promotionProduct);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while saving promotion product: " + e.getMessage());
			// Thêm các xử lý lỗi cần thiết ở đây, ví dụ như ghi log hoặc gửi thông báo
		}

		return null;
	}

	public PromotionProductDetail getProductByBarcode(String barcode) {
		System.out.println("Product Promotion Service - Get Product Promotion By Barcode");

		try {
			List<PromotionProduct> rs = promotionProductRepository.getProductPromotionByBarcode(barcode);

			if (rs.isEmpty()) {
				System.err.println("No product promotions found for the given barcode.");
				return null;
			}

			System.out.println(rs.get(0).getListPromotionProduct());

			for (PromotionProductDetail ppd : rs.get(0).getListPromotionProduct()) {
				if (ppd.getBarcode().equals(barcode)) {
					return ppd;
				}
			}

			System.err.println("No promotion product detail found for the given barcode.");

		} catch (Exception e) {
			System.err.println("An error occurred while fetching product promotion details: " + e.getMessage());
		}

		return null;
	}

	public List<PromotionProduct> getProductPromotions() {
		System.out.println("Product Promotion Service - Get Product Promotions");

		try {
			return promotionProductRepository.findAll();
		} catch (Exception e) {
			System.err.println("Error occurred while fetching product promotions: " + e.getMessage());
			return Collections.emptyList(); // hoặc một giá trị lỗi phù hợp khác
		}
	}

	public List<PromotionProduct> getProductPromotionsByTypeInRange(String type, int page, int size) {
		System.out.println("Product Promotion Service - Get Product Promotions By Type In Range");
		Pageable pageable = PageRequest.of(page - 1, size);

		try {
			switch (type) {
			case "all": {
				return promotionProductRepository.getPromotionInRange(pageable);
			}
			case "active": {
				return promotionProductRepository.getPromotionByStatusInRange(type, pageable);
			}
			case "inactive": {
				return promotionProductRepository.getPromotionByStatusInRange(type, pageable);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while fetching promotion products: " + e.getMessage());
			return Collections.emptyList();
		}
	}

	public void updateStatusInactive(LocalDateTime time) {
		System.out.println("Product Promotion Service - Update Status Product Promotions Is Inactive");

		try {
			promotionProductRepository.updateStatusInactive(time);
		} catch (Exception e) {
			System.err.println("Error occurred while updating status to inactive: " + e.getMessage());
		}
	}

	public List<PromotionProduct> getPromotionByNameAndStatusInRange(String name, String status, int page, int size) {
		System.out.println("Product Promotion Service - Get Promotion By Name And Status In Range");
		Pageable pageable = PageRequest.of(page - 1, size);

		try {
			switch (status) {
			case "all": {
				return promotionProductRepository.getPromotionByNameInRange(name, pageable);
			}
			case "active": {
				return promotionProductRepository.getPromotionByNameAndStatusInRange(name, status, pageable);
			}
			case "inactive": {
				return promotionProductRepository.getPromotionByNameAndStatusInRange(name, status, pageable);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + status);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while fetching promotions by name and status: " + e.getMessage());
			return Collections.emptyList();
		}
	}
	
	public PromotionProduct getPromotionByID(IDPromotionProduct idPromotionProduct) {
	    System.out.println("Promotion Service - Get Promotion By ID");

	    try {
	        return promotionProductRepository.findById(idPromotionProduct).orElseThrow();
	    } catch (Exception e) {
	        System.err.println("An error occurred while fetching promotion by ID: " + e.getMessage());
	        return null; 
	    }
	}

	public PromotionProduct updatePromotionByID(PromotionProduct promotionProduct) {
		// TODO Auto-generated method stub
		  System.out.println("Promotion Service - Update Promotion By ID");

		    try {
		        return promotionProductRepository.saveAndFlush(promotionProduct);
		    } catch (Exception e) {
		        System.err.println("An error occurred while fetching promotion by ID: " + e.getMessage());
		        return null; 
		    }
	}


}
