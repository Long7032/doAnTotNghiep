package com.example.demo.service;

import java.util.ArrayList;
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
			System.err.println("An error occurred while saving the account: " + e.getMessage());
			return null;
		}
	}

	public List<Account> getAccounts() {
		System.out.println("Account Service - Get All Accounts");
		try {
			return accountRepository.findAll();
		} catch (Exception e) {
			System.err.println("An error occurred while getting all accounts: " + e.getMessage());
			return new ArrayList<>();
		}
	}

	public Account getAccount(Account account) {
		System.out.println("Account Service - Get Account By Email And Password");
		try {
			Account rs = accountRepository.getAccount(account.getUserName());
			if (passwordEncoder.matches(account.getPassword(), rs.getPassword())) {
				return rs;
			}
		} catch (Exception e) {
			System.err.println("An error occurred while getting the account: " + e.getMessage());
		}
		return null;
	}

	public Account checkAccount(Account account) {
		System.out.println("Account Service - Check Account");
		try {
			return accountRepository.getAccount(account.getUserName());
		} catch (Exception e) {
			System.err.println("An error occurred while checking the account: " + e.getMessage());
			return null;
		}
	}

	public Account updateAccountByType(String option, Account account) {
		System.out.println("Account Service - Update Account By Type");
		try {
			Account rs = accountRepository.getAccount(account.getUserName());

			switch (option) {
			case "all": {
				rs.setUserName(account.getUserName());
				String encodedPassword = passwordEncoder.encode(account.getPassword());
				rs.setPassword(encodedPassword);
				break;
			}
			case "email": {
				rs.setUserName(account.getUserName());
				break;
			}
			case "password": {
				String encodedPassword = passwordEncoder.encode(account.getPassword());
				rs.setPassword(encodedPassword);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}

			return accountRepository.saveAndFlush(rs);
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid option: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("An error occurred while updating account: " + e.getMessage());
			throw e;
		}
		return null;
	}

}
