package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String generateOTP(@PathVariable String email) throws ParseException {
		return otpService.generateOTP(email);
	}

	@PostMapping("/check")
	public String checkOTP(@RequestBody OTP otp) {
		System.out.println(otp);
		return otpService.checkingOTP(otp.getEmailUser(), otp.getMessage());
	}

}
