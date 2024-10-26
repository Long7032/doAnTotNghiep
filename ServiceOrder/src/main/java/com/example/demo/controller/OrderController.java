package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/")
	public ResponseEntity<Object> saveOrder(@RequestBody Order order) {
		// TODO: process POST request

		return ResponseEntity.status(200).body(orderService.saveOrder(order));
	}

	@PostMapping("/order")
	public Optional<Order> getOrder(@RequestBody Order order) {
		return orderService.getOrder(order);
	}

	@GetMapping("/{idUser}")
	public ResponseEntity<Object> getOrdersByUser(@PathVariable String idUser) {
		return ResponseEntity.status(200).body(orderService.getOrdersByUser(idUser));
	}

	@GetMapping("/{page}/{size}")
	public ResponseEntity<Object> getOrderInRange(@PathVariable int page, @PathVariable int size) {
		return ResponseEntity.status(200).body(orderService.getProductInRange(page, size));
	}

	@GetMapping("/{status}/{page}/{size}")
	public ResponseEntity<Object> getOrderByCurrentStatusInRange(@PathVariable String status, @PathVariable int page, @PathVariable int size) {
		System.out.println("Order Controller - Get Order By Current Status In Range");
		List<Order> rs = orderService.getOrderByCurrentStatusInRange(status, page, size);
		return ResponseEntity.status(200).body(rs);
	}

	@PutMapping("/")
	public ResponseEntity<Object> putMethodName(@RequestBody Order order) {
		// TODO: process PUT request
		return ResponseEntity.status(200).body(orderService.updateNewStatusOrder(order));
	}

}
