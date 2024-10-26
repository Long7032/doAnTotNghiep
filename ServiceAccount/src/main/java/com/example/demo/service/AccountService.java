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
		return  accountRepository.save(account);
	}

	public List<Account> getAccounts() {
		System.out.println("Account Service - Get All Accounts");
		return accountRepository.findAll();
	}

	public Account getAccount(Account account) {
		System.out.println("Account Service - Get Account By Email And Password");
		Account rs = null;
		rs = accountRepository.getAccount(account.getUserName());
		return rs;
	}
	
	public Account updateAccount(Account account) {
		System.out.println("Account Service - Update Account");
		Account rs = null;
		rs = accountRepository.getAccount(account.getUserName());
		if(rs != null) {
			if(!account.getPassword().isEmpty()) {
				String encodePassword = passwordEncoder.encode(account.getPassword());
				rs.setPassword(encodePassword);
				return accountRepository.saveAndFlush(rs);
			}
		}
		return null;
	}
	
	public Account checkAccount(Account account) {
		Account rs = null;
		rs = accountRepository.getAccount(account.getUserName());
		if(rs != null) {
			return rs;
		}
		return null;
	}
}
