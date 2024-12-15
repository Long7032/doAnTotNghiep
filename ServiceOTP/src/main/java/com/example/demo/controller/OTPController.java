package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OTP;
import com.example.demo.service.OTPService;

@RestController
@RequestMapping("/api/otps")
public class OTPController {

	@Autowired
	private OTPService otpService;

	@GetMapping("/")
	public List<OTP> getListOTP() {
		return otpService.getOTPs();
	}

	@PostMapping("/{email}")
	public ResponseEntity<Object> generateOTP(@PathVariable String email) {
		try {
			return ResponseEntity.status(200).body(otpService.generateOTP(email));
		} catch (ParseException e) {
			System.err.println("An error occurred while generating OTP: " + e.getMessage());
			return ResponseEntity.status(400).body("Invalid request format");
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@PostMapping("/check")
	public ResponseEntity<Object> checkOTP(@RequestBody OTP otp) {
		try {
			System.out.println(otp);
			String rsCheckOTP = otpService.checkingOTP(otp.getEmailUser(), otp.getMessage());
			System.out.println(rsCheckOTP);
			return ResponseEntity.status(200).body(rsCheckOTP);
		} catch (Exception e) {
			System.err.println("An error occurred while checking OTP: " + e.getMessage());
			return ResponseEntity.status(500)
					.body("An error occurred while processing your request. Please try again later.");
		}
	}
//	@PostMapping("/order/{email}")
	public ResponseEntity<Object> sendToEmail(@PathVariable String email) {
		try {
			return ResponseEntity.status(200).body(otpService.generateOTP(email));
		} catch (ParseException e) {
			System.err.println("An error occurred while generating OTP: " + e.getMessage());
			return ResponseEntity.status(400).body("Invalid request format");
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}
}
