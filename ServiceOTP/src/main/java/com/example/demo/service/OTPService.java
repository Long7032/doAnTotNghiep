package com.example.demo.service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OTP;
import com.example.demo.repository.OTPRepository;

@Service
public class OTPService {
	@Autowired
	private OTPRepository otpRepository;
	@Autowired
	private JavaMailSender mailSender;

	public String generateOTP(String email) throws ParseException {
		System.out.println(email);
		Random random = new Random();

		int otpValue = 100000 + random.nextInt(900000);
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiry = now.plusMinutes(1);

		OTP otp = new OTP(email, String.valueOf(otpValue), now, expiry);
		try {
			otpRepository.save(otp);

			sendOTPByEmail(email, otp.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			return "OTP has been sent. Please try again after 5 minutes.";
		}
	return "Send OTP Success";
	}

	public String checkingOTP(String email, String otp) {
		OTP o = null;
		o = otpRepository.findOTP(email);
		if(o != null) {
			String rs = "OTP Invalid";
			if (o.getMessage().equalsIgnoreCase(otp)) {
				rs = "OTP Valid";
				otpRepository.delete(o);
			}
			return rs;
		}
		return "OTP Expired";
	}

	public void sendOTPByEmail(String toEmail, String otp) throws ParseException {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(toEmail);
		message.setSubject("Xác thực OTP");
		message.setText(new Date().toString() + "Mã OTP của bạn là " + otp + ". Mã OTP sẽ hết hạn sau 5 phút nữa");
		message.setFrom("gaming@gmail.com");

		mailSender.send(message);
	}

	public List<OTP> getOTPs() {
		return otpRepository.findAll();
	}
}
