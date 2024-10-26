package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartID;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	public Cart saveCart(Cart cart) {
		System.out.println("Data Init: " + cart);
		return cartRepository.save(cart);
	}

	public Cart updateCart(Cart cart) {
		Optional<Cart> rs = cartRepository.findById(new CartID(cart.getId(), cart.getIdUser()));
		Cart cartConvert = rs.orElseThrow(() -> new NoSuchElementException("Cart not found"));
		cartConvert.setTimeUpdated(LocalDateTime.now());
		cartConvert.setListCartItem(cart.getListCartItem());
		return cartRepository.saveAndFlush(cartConvert);
	}

	public Cart deleteCart(Cart cart) {
		cartRepository.deleteById(new CartID(cart.getId(), cart.getIdUser()));
		return cartRepository.findById(new CartID(cart.getId(), cart.getIdUser()))
				.orElseThrow(() -> new NoSuchElementException("Cart not found"));
	}

	public Optional<Cart> getCartByID(Cart cart) {
		Optional<Cart> rs = cartRepository.findById(new CartID(cart.getId(), cart.getIdUser()));
		return rs;

	}
}
