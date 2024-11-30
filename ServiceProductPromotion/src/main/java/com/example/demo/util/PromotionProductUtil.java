package com.example.demo.util;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.repository.PromotionProductRepository;

@Component
public class PromotionProductUtil {
	@Autowired
	private PromotionProductRepository promotionProductRepository;

	@Scheduled(fixedRate = 600000) // Chạy mỗi phút
	public void cleanUpExpiSredOtps() {
		LocalDateTime now = LocalDateTime.now();
		promotionProductRepository.updateStatusInactive(now);
	}
}
