package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderDetail;
import com.example.demo.service.OrderDetailService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/order-details")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;

	@PostMapping("/")
	public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail) {
		// TODO: process POST request
//		sysout
		return orderDetailService.saveOrderDetail(orderDetail);
	}

	@GetMapping("/")
	public List<OrderDetail> getOrderDetails() {
		return orderDetailService.getOrderDetails();
	}

}
