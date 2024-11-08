package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderStatus;
import com.example.demo.service.OrderStatusService;

@RestController
@RequestMapping("/api/order-statuss")
public class OrderStatusController {
	@Autowired
	private OrderStatusService orderStatusService;

	@PostMapping("/")
	private ResponseEntity<Object> saveOrderStatus(@RequestBody OrderStatus orderStatus) {
		System.out.println("Order Status Controller - Save Order Status");
		OrderStatus rs = orderStatusService.saveOrderStatus(orderStatus);
		if (rs == null) {
			return ResponseEntity.status(200).body(new String("fail"));
		}
		return ResponseEntity.status(200).body(rs);
	}

	@GetMapping("/")
	public List<OrderStatus> getOrderStatuss() {
		return orderStatusService.getOrderStatuss();
	}

}
