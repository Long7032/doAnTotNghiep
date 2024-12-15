package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		try {
			Account rs = accountService.saveAccount(account);
			if (rs == null) {
				return ResponseEntity.status(500).body("Failed to save account. Please try again later.");
			}
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while saving the account: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@PostMapping("/check")
	public ResponseEntity<Object> checkAccount(@RequestBody Account account) {
		// TODO: process POST request
		System.out.println("Account Controller - Check Account: " + account);
		try {
			Account rs = accountService.checkAccount(account);
			if (rs == null) {
				return ResponseEntity.status(400).body("Account Not Found");
			}
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while checking the account: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Object> getAccount(@RequestBody Account account) {
		System.out.println("Account Controller - Login - Data: " + account);
		try {
			Account rs = accountService.getAccount(account);
			if (rs == null) {
				return ResponseEntity.status(401).body("Account Not Found !!!");
			}
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while logging in: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@GetMapping("/")
	public ResponseEntity<Object> getAccounts() {
		try {
			List<Account> accounts = accountService.getAccounts();
			return ResponseEntity.status(200).body(accounts);
		} catch (Exception e) {
			System.err.println("An error occurred while getting accounts: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@PutMapping("/{type}")
	public ResponseEntity<Object> updateAccountByType(@PathVariable String type, @RequestBody Account account) {
		System.out.println("Account Controller - Update Account By Type - Data: " + account);
		try {
			Account rs = accountService.updateAccountByType(type, account);
			System.out.println(rs);
			if (rs == null) {
				return ResponseEntity.status(401).body("Account Not Found !!!");
			}
			return ResponseEntity.status(200).body(rs);
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid option: " + e.getMessage());
			return ResponseEntity.status(400).body("Invalid option provided.");
		} catch (Exception e) {
			System.err.println("An error occurred while updating account: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

}
