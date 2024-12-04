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

	public List<OrderDetail> saveOrderDetail(List<OrderDetail> orderDetails) {
		System.out.println("Order Detail Service - Save Order Detail");
		List<OrderDetail> list = null;
		try {
			list = orderDetailRepository.saveAll(orderDetails);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<OrderDetail> getOrderDetails() {
		System.out.println("Order Detail Service - Get All Order Detail");
		return orderDetailRepository.findAll();
	}

	public List<OrderDetail> getOrderDetailsByIDOrder(String id) {
		System.out.println("Order Detail Service - Get Order Details By Order ID");
		return orderDetailRepository.getOrderDetailsByOrderID(id);
	}

	public void deleteAllOrderDetailByOrderID(OrderDetail orderDetail) {
		System.out.println("Order Detail Service - Delete Order Detail By Order ID");
		orderDetailRepository.deleteAllOrderDetailByOrderID(orderDetail.getIdOrder());
	}

	public void resetService() {
		System.out.println("Order Detail Service - Reset Service");
		orderDetailRepository.deleteAll();
	}
	
	public List<Object[]> calculatorOrder(OrderDetail orderDetail){
		System.out.println("Order Detail Service - Calculator Order");
		return orderDetailRepository.calculatorOrder(orderDetail.getIdOrder());
	}
	
	public List<Object[]> getTopProductBestSelling(){
		System.out.println("Order Detail Service - Get Top Product Best Selling");
		return orderDetailRepository.getTopProductBestSelling();
	}
}
