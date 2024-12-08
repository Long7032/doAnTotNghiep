package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

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
		System.out.println("Order Controller - Save Order");
		try {
			Order savedOrder = orderService.saveOrder(order);
			return ResponseEntity.status(200).body(savedOrder);
		} catch (Exception e) {
			System.err.println("An error occurred while saving the order: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(500).body("An error occurred while saving the order.");
		}
	}

	@PostMapping("/order")
	public ResponseEntity<Object> getOrder(@RequestBody Order order) {
		System.out.println("Order Controller - Get Order By ID Order And Id User");
		try {
			Order retrievedOrder = orderService.getOrderByIdUserAndIdOrder(order);
			return ResponseEntity.status(200).body(retrievedOrder);
		} catch (Exception e) {
			System.err.println("An error occurred while retrieving the order: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(500).body("An error occurred while retrieving the order.");
		}
	}

	@PostMapping("/order-id")
	public ResponseEntity<Object> getOrdersByIdOrder(@RequestBody Order order) {
		System.out.println("Order Controller - Get Order By Order ID");
		return ResponseEntity.status(200).body(orderService.getOrderByID(order));
	}

	@GetMapping("/{idUser}")
	public ResponseEntity<Object> getOrdersByUser(@PathVariable String idUser) {
		return ResponseEntity.status(200).body(orderService.getOrdersByUser(idUser));
	}

	@GetMapping("/{page}/{size}")
	public ResponseEntity<Object> getOrderInRange(@PathVariable int page, @PathVariable int size) {
		return ResponseEntity.status(200).body(orderService.getOrderInRange(page, size));
	}

	@GetMapping("/{status}/{page}/{size}")
	public ResponseEntity<Object> getOrderByCurrentStatusInRange(@PathVariable String status, @PathVariable int page,
			@PathVariable int size) {
		System.out.println("Order Controller - Get Order By Current Status In Range");
		List<Order> rs = orderService.getOrderByCurrentStatusInRange(status, page, size);
		return ResponseEntity.status(200).body(rs);
	}

	@PutMapping("/")
	public ResponseEntity<Object> updateStatusOrder(@RequestBody Order order) {
		// TODO: process PUT request
		System.out.println("Order Controller - Update New Status Order");
		return ResponseEntity.status(200).body(orderService.updateNewStatusOrder(order));
	}

	@GetMapping("/status-count-order")
	public ResponseEntity<Object> countOrdersByStatus() {
		System.out.println("Order Controller - Count Order By Status");
		return ResponseEntity.status(200).body(orderService.countOrdersByStatus());
	}

	@PostMapping("/time-count-order")
	public ResponseEntity<Object> countOrdersByTime(@RequestBody Order order) {
		System.out.println("Order Controller - Count Order By Time");
		return ResponseEntity.status(200).body(orderService.countOrdersByTime(order.getDateTime()));
	}

	@GetMapping("/count-total-order-time/{timeStart}/{timeEnd}")
	public ResponseEntity<Object> countOrdersInRangeTime(@PathVariable LocalDateTime timeStart,@PathVariable LocalDateTime timeEnd) {
		System.out.println("Order Controller - Count Order In Range Time");

		try {
			List<Object[]> result = orderService.countOrdersInRangeTime(timeStart, timeEnd);
			return ResponseEntity.status(200).body(result);
		} catch (Exception e) {
			System.err.println("An error occurred while counting orders in range time: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(500).body("An error occurred while counting orders in range time.");
		}
	}
	
	@GetMapping("/count-all-total-order-time/{timeStart}/{timeEnd}")
	public ResponseEntity<Object> countAllTotalOrdersInRangeTime(@PathVariable LocalDateTime timeStart,@PathVariable LocalDateTime timeEnd) {
		System.out.println("Order Controller - Count Order In Range Time");

		try {
			List<Object[]> result = orderService.countTotalOrdersInRangeTime(timeStart, timeEnd);
			return ResponseEntity.status(200).body(result);
		} catch (Exception e) {
			System.err.println("An error occurred while counting orders in range time: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(500).body("An error occurred while counting orders in range time.");
		}
	}
	
	@GetMapping("/count-status-total-order-time/{timeStart}/{timeEnd}")
	public ResponseEntity<Object> countTotalOrdersByStatusInRangeTime(@PathVariable LocalDateTime timeStart,@PathVariable LocalDateTime timeEnd) {
		System.out.println("Order Controller - Count Order By Status In Range Time");

		try {
			List<Object[]> result = orderService.countTotalOrdersByStatusInRangeTime(timeStart, timeEnd);
			return ResponseEntity.status(200).body(result);
		} catch (Exception e) {
			System.err.println("An error occurred while counting orders in range time: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(500).body("An error occurred while counting orders in range time.");
		}
	}

}
