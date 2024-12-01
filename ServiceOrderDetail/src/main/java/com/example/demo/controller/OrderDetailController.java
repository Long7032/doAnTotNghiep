package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderDetail;
import com.example.demo.service.OrderDetailService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/order-details")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;

	@PostMapping("/")
	public ResponseEntity<Object> saveOrderDetail(@RequestBody List<OrderDetail> orderDetails) {
		// TODO: process POST request
		System.out.println("Order Detail Controller - Save Order Detail");
		return ResponseEntity.status(200).body(orderDetailService.saveOrderDetail(orderDetails));
	}

	@DeleteMapping("/id-order")
	public ResponseEntity<Object> deleteAllOrderDetailByOrderID(@RequestBody OrderDetail orderDetail) {
		System.out.println("Order Detail Controller - Delete All Order Detail By Order ID");
		orderDetailService.deleteAllOrderDetailByOrderID(orderDetail);
		return ResponseEntity.status(200).body(new String("Delete Success"));
	}

	@GetMapping("/")
	public ResponseEntity<Object> getOrderDetails() {
		System.out.println("Order Detail Controller - Get Order Details");
		return ResponseEntity.status(200).body(orderDetailService.getOrderDetails());
	}

	@GetMapping("/id-order/{id}")
	public ResponseEntity<Object> getOrderDetailsByOrderID(@PathVariable String id) {
		System.out.println("Order Detail Controller - Get Order Details By Order ID");
		return ResponseEntity.status(200).body(orderDetailService.getOrderDetailsByIDOrder(id));
	}

	@DeleteMapping("/reset-service")
	public ResponseEntity<Object> deleteAllOrderDetail() {
		System.out.println("Order Detail Controller - Delete All Order Detail By Order ID");
		orderDetailService.resetService();
		return ResponseEntity.status(200).body(new String("Reset Service Success"));
	}
	@PostMapping("/calculator")
	public ResponseEntity<Object> calculatorOrder(@RequestBody OrderDetail orderDetail) {
		//TODO: process POST request
		System.out.println("Order Detail - Calculator Order");
		return ResponseEntity.status(200).body(orderDetailService.calculatorOrder(orderDetail));
	}
	

}
