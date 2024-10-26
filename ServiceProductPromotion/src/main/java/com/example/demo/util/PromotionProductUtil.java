package com.example.demo.util;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PromotionProductUtil {
	@Scheduled(fixedRate = 60000) // Chạy mỗi phút
	public void cleanUpExpiSredOtps() {
		LocalDateTime now = LocalDateTime.now();
//		otpInfoRepository.deleteExpiredOtps(now);
	}
}
