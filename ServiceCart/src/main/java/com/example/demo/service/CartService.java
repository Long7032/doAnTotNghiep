package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.HashSet;
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
		System.out.println("Cart Service - Save Cart");
		System.out.println("Data Init: " + cart);
		Cart rs = null;
		cart.setListCartItem(new HashSet<>());

		try {
			rs = cartRepository.save(cart);
		} catch (Exception e) {
			System.err.println("An error occurred while saving the cart: " + e.getMessage());
		}

		return rs;
	}

	public Cart updateCart(Cart cart) {
		System.out.println("Cart Service - Update Cart");
		try {
			Optional<Cart> rs = cartRepository.findById(new CartID(cart.getId(), cart.getIdUser()));
			Cart cartConvert = rs.orElseThrow(() -> new NoSuchElementException("Cart not found"));
			cartConvert.setTimeUpdated(LocalDateTime.now());
			cartConvert.setListCartItem(cart.getListCartItem());
			return cartRepository.saveAndFlush(cartConvert);
		} catch (NoSuchElementException e) {
			System.err.println("An error occurred: " + e.getMessage());
			return null;
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
			return null;
		}
	}

	public Cart deleteCart(Cart cart) {
		System.out.println("Cart Service - Delete Cart");
		try {
			cartRepository.deleteById(new CartID(cart.getId(), cart.getIdUser()));
			return cartRepository.findById(new CartID(cart.getId(), cart.getIdUser()))
					.orElseThrow(() -> new NoSuchElementException("Cart not found"));
		} catch (NoSuchElementException e) {
			System.err.println("Cart not found: " + e.getMessage());
			return null;

		} catch (Exception e) {
			System.err.println("An error occurred while deleting the cart: " + e.getMessage());
			return null;
		}
	}

	public Cart getCartByID(Cart cart) {
		System.out.println("Cart Service - Get Cart By ID Cart And ID User");
		try {
			Cart rs = cartRepository.findById(new CartID(cart.getId(), cart.getIdUser()))
					.orElseThrow(() -> new NoSuchElementException("Cart not found"));
			return rs;
		} catch (NoSuchElementException e) {
			System.err.println("Cart not found: " + e.getMessage());
			return null;
		} catch (Exception e) {
			System.err.println("An error occurred while getting the cart by ID: " + e.getMessage());
			return null;
		}
	}

	public Cart getCartByUserID(Cart cart) {
		System.out.println("Cart Service - Get Cart By User ID");
		try {
			return cartRepository.findCartByUserID(cart.getIdUser());
		} catch (Exception e) {
			System.err.println("An error occurred while getting the cart by user ID: " + e.getMessage());
			return null;
		}
	}

}
