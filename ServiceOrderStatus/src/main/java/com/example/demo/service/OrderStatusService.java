package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderStatus;
import com.example.demo.repository.OrderStatusRepository;

@Service
public class OrderStatusService {
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	public OrderStatus saveOrderStatus(OrderStatus orderStatus) {
		orderStatus.setTime(LocalDateTime.now());
		return orderStatusRepository.save(orderStatus);
	}

	public List<OrderStatus> getOrderStatuss() {
		// TODO Auto-generated method stub
		return orderStatusRepository.findAll();
	}
}
