package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	@Query("SELECT a FROM Account a WHERE a.userName = ?1")
	public Account getAccount(String username);

}
