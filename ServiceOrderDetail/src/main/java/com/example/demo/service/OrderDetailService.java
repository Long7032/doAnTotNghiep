package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.OrderDetailRepository;


@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
		return orderDetailRepository.save(orderDetail);
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetailRepository.findAll();
	}

}
