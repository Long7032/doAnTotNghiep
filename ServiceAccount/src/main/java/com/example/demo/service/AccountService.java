package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Account saveUser(Account account) {
		System.out.printf("Service: \s", account);
		String encodedPassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(encodedPassword);
		System.out.println("Service: " + account);
		return accountRepository.save(account);
	}

	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

	public Account getAccount(String email, String password) {
		Account rs = null;
		rs = accountRepository.getAccount(email);
		if (rs != null) {
			System.out.println("Account Service: ");
			System.out.println(password);
			System.out.println(rs);

			System.out.println(passwordEncoder.matches(password, rs.getPassword()));
			return rs;
		}
		return rs;
	}

	public Account changePassword(Account account) {
		Account rs = null;
		rs = accountRepository.getAccount(account.getUserName());
		String encodePassword = passwordEncoder.encode(account.getPassword());
		rs.setPassword(encodePassword);
		return accountRepository.saveAndFlush(rs);
	}
	
	public Account updateAccount(Account account) {
		return accountRepository.saveAndFlush(account);
	}
}
