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
		Cart rs = cartService.saveCart(cart);
		return ResponseEntity.status(200).body(rs);
	}

	@PatchMapping("/")
	public ResponseEntity<Object> updateCart(@RequestBody Cart cart) {
		Cart rs = cartService.updateCart(cart);
		return ResponseEntity.status(200).body(rs);
	}

	@DeleteMapping("/")
	public ResponseEntity<Object> deleteCart(@RequestBody Cart cart) {
		Cart rs = cartService.deleteCart(cart);
		return ResponseEntity.status(200).body(rs);
	}

	@PostMapping("/id")
	public ResponseEntity<Object> getCartByID(@RequestBody Cart cart) {
		return ResponseEntity.status(200).body(cartService.getCartByID(cart));
	}
	
	@PostMapping("/id-user")
	public  ResponseEntity<Object> getCartByUserId(@RequestBody Cart cart) {
		//TODO: process POST request
		System.out.println("Cart Controller - Get Cart By User ID");
		return ResponseEntity.status(200).body(cartService.getCartByUserID(cart));
	}
	

}
