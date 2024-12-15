package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartID;

import jakarta.transaction.Transactional;

public interface CartRepository extends JpaRepository<Cart, CartID> {
	
	@Transactional
	@Query("SELECT c FROM Cart c WHERE c.idUser = ?1")
	public Cart findCartByUserID(String id);

}
