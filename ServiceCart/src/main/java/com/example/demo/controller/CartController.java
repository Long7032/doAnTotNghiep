package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
	@Autowired
	private CartService cartService;

	@PostMapping("/")
	public ResponseEntity<Object> saveCart(@RequestBody Cart cart) {
		System.out.println("Cart Controller - Save Cart");
		try {
			Cart rs = cartService.saveCart(cart);
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while saving the cart: " + e.getMessage());
			return ResponseEntity.status(500).body("An error occurred while saving the cart.");
		}
	}

	@PatchMapping("/")
	public ResponseEntity<Object> updateCart(@RequestBody Cart cart) {
		try {
			Cart rs = cartService.updateCart(cart);
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while updating the cart: " + e.getMessage());
			return ResponseEntity.status(500).body("An error occurred while updating the cart.");
		}
	}

	@DeleteMapping("/")
	public ResponseEntity<Object> deleteCart(@RequestBody Cart cart) {
		try {
			Cart rs = cartService.deleteCart(cart);
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while deleting the cart: " + e.getMessage());
			return ResponseEntity.status(500).body("An error occurred while deleting the cart.");
		}
	}

	@PostMapping("/id")
	public ResponseEntity<Object> getCartByID(@RequestBody Cart cart) {
		try {
			Cart rs = cartService.getCartByID(cart);
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while getting the cart by ID: " + e.getMessage());
			return ResponseEntity.status(500).body("An error occurred while getting the cart by ID.");
		}
	}

	@PostMapping("/id-user")
	public ResponseEntity<Object> getCartByUserId(@RequestBody Cart cart) {
		System.out.println("Cart Controller - Get Cart By User ID");
		try {
			Cart rs = cartService.getCartByUserID(cart);
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while getting the cart by user ID: " + e.getMessage());
			return ResponseEntity.status(500).body("An error occurred while getting the cart by user ID.");
		}
	}

}
