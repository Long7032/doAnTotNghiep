package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public ResponseEntity<Object> saveAccount(@RequestBody Account account) {
		// TODO: process POST request
		System.out.println("Account Controller - Save Account: " + account);
		Account rs = accountService.saveAccount(account);
		return ResponseEntity.status(200).body(rs);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> getAccount(@RequestBody Account account) {
		System.out.println("Account Controller - Login - Data: " + account);
		Account rs = accountService.getAccount(account);
		if (rs == null) {
			return ResponseEntity.status(401).body(new String("Account Not Found !!!"));
		}
		return ResponseEntity.status(200).body(rs);
	}

	@PutMapping("/")
	public ResponseEntity<Object> updateAccount(@RequestBody Account account) {
		System.out.println("Account Controller - Update - Data: " + account);
		Account rs = null;
		rs = accountService.updateAccount(account);
		if (rs != null) {
			return ResponseEntity.status(200).body("Success");
		}
		return ResponseEntity.status(401).body(new String("Fail"));
	}

	@GetMapping("/")
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}

	@PostMapping("/check")
	public ResponseEntity<Object> checkAccount(@RequestBody Account account) {
		System.out.println("Account Controller - Check - Data: " + account);
		Account rs = accountService.checkAccount(account);
		System.out.println(rs);
		if (rs == null) {
			return ResponseEntity.status(401).body(new String("Account Not Found !!!"));
		}
		return ResponseEntity.status(200).body(new String("Account Has Been Exists"));
	}
}
