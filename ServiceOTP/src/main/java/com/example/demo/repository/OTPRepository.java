package com.example.demo.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.OTP;

import jakarta.transaction.Transactional;

public interface OTPRepository extends JpaRepository<OTP, Integer> {
	@Query("SELECT o FROM OTP o WHERE o.emailUser= ?1")
	public OTP findOTP(String email);
	
	@Modifying
    @Transactional
    @Query("DELETE FROM OTP o WHERE o.timeEnd <= ?1")
    void deleteExpiredOtps(LocalDateTime now);
}
