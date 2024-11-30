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

	public Account saveAccount(Account account) {
		System.out.println("Account Service - Save Account");
		String encodedPassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(encodedPassword);
		try {
			return accountRepository.save(account);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<Account> getAccounts() {
		System.out.println("Account Service - Get All Accounts");
		return accountRepository.findAll();
	}

	public Account getAccount(Account account) {
		System.out.println("Account Service - Get Account By Email And Password");
		Account rs = null;
		rs = accountRepository.getAccount(account.getUserName());
		if (passwordEncoder.matches(account.getPassword(), rs.getPassword())) {
			return rs;
		}
		return null;
	}

	public Account checkAccount(Account account) {
		System.out.println("Account Service - Check Account");
//		Account rs = null;
		return accountRepository.getAccount(account.getUserName());
	}
	
	public Account updateAccountByType(String option, Account account) {
		System.out.println("Account Service - Update Account By Type");
		Account rs = accountRepository.findById(account.getIdUser()).orElseThrow();
		switch (option) {
		case "all": {
			rs.setUserName(account.getUserName());
			String encodedPassword = passwordEncoder.encode(account.getPassword());
			account.setPassword(encodedPassword);
			break;
		}
		case "email": {
			rs.setUserName(account.getUserName());
			break;
		}
		case "password": {
			String encodedPassword = passwordEncoder.encode(account.getPassword());
			account.setPassword(encodedPassword);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

		return accountRepository.saveAndFlush(rs);
	}
}
