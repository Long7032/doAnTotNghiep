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
	
	@PostMapping("/id")
	public ResponseEntity<Object> getAllOrderStatusById(@RequestBody OrderStatus orderStatus) {
		//TODO: process POST request
		System.out.println("Order Status Controller - Get All Order Status By ID");
		List<OrderStatus> list = orderStatusService.getOrderStatussByID(orderStatus);
		
		return ResponseEntity.status(200).body(list);
	}
	
	@PostMapping("/id/status")
	public ResponseEntity<Object> getOrderStatusByIdAndStatus(@RequestBody OrderStatus orderStatus) {
		//TODO: process POST request
		System.out.println("Order Status Controller - Get Order Status By ID And Status");
		List<OrderStatus> list = orderStatusService.getOrderStatusByIDAndStatus(orderStatus);
		
		return ResponseEntity.status(200).body(list.get(0));
	}
	

}
