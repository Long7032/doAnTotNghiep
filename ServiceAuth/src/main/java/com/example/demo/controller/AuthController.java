package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AES;
import com.example.demo.entity.Token;
import com.example.demo.util.AESUtil;
import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AESUtil aesUtil;
	
	@PostMapping("/create")
	public ResponseEntity<Object> createToken(@RequestBody Token token) throws Exception {
		String rs = jwtUtil.generateToken(token);
		return ResponseEntity.status(200).body(new String(aesUtil.encrypt(rs)));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<Object> authToken(@RequestBody AES aes) throws Exception {
		System.out.println("Auth Controller - Authenticate");
//		
		// Encrypt AES
		String encryptAES = aes.getEncrytText();
		System.out.println("Encrypt AES: " + encryptAES);
		
		// Decrypt AES
		String decryptAES = aesUtil.decrypt(encryptAES);
		System.out.println("Decrypt AES: " + decryptAES);
		
		// Decrypt Token
		String token = jwtUtil.authenticate(decryptAES);
		System.out.println("Token: " + token);
		
		String id = jwtUtil.getIDFromToken(decryptAES);
		
		return ResponseEntity.status(200).body(new String(id));
//		return ResponseEntity.status(200).body(new String(jwtUtil.authenticate(aesUtil.decrypt(aes.getEncrytText()))));
	}
	
	
	@PostMapping("/demo/{token}")
	public ResponseEntity<Object> demo(@PathVariable String token) throws Exception {
		return ResponseEntity.status(200).body(new String(token));
	}
	
}
