package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public Account saveAccount(@RequestBody Account account) {
		// TODO: process POST request
		System.out.println("Account Controller - Register - Data: " + account);
		return accountService.saveUser(account);
	}

	// GET http://localhost:5821/accounts/?userName=abc&password=123
	@PostMapping("/login")
	public Account getAccount(@RequestBody Account account) {
		System.out.println("Account Controller - Login - Data: " + account);
		return accountService.getAccount(account.getUserName(), account.getPassword());
	}

	@PutMapping("/")
	public Account updateAccount(@RequestBody Account account) {
		System.out.println("Account Controller - Update - Data: " + account);

		return accountService.updateAccount(account);
	}

	@PatchMapping("/")
	public Account changePassword(@RequestBody Account account) {
		System.out.println("Account Controller - Change Password - Data: " + account);
		return accountService.changePassword(account);
	}

	@GetMapping("/")
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}
}
