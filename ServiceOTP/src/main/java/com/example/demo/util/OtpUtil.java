package com.example.demo.util;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.repository.OTPRepository;

@Component
public class OtpUtil {
	@Autowired
	private OTPRepository otpInfoRepository;

	@Scheduled(fixedRate = 60000) // Chạy mỗi phút
	public void cleanUpExpiredOtps() {
		LocalDateTime now = LocalDateTime.now();
		otpInfoRepository.deleteExpiredOtps(now);
	}
}
