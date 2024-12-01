package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IDOrder;
import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public Order saveOrder(Order order) {
		System.out.println("Order Service - Save Order");

		// Generate Order ID
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Random random = new Random();
		int randomValue = 100000 + random.nextInt(900000);

		String id = "HD" + sdf.format(new Date()) + String.valueOf(randomValue);
		order.setIdOrder(id);

		return orderRepository.save(order);
	}

	public List<Order> getOrdersByUser(String id) {
		return orderRepository.getOrdersByUser(id);
	}

	public List<Order> getProductInRange(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return orderRepository.getOrderInRange(pageable);
	}

	public List<Order> getOrderByCurrentStatusInRange(String status, int page, int size) {
		System.out.println("Order Service - Get Order By Current Status In Range");

		System.out.println("Data Init - Status: " + status);
		Pageable pageable = PageRequest.of(page - 1, size);

		List<Order> rs = null;

		switch (status) {
		case "all": {
			rs = orderRepository.getOrderInRange(pageable);
			break;
		}
		case "create": {
			rs = orderRepository.getOrderByCurrentStatus(status, pageable);
			break;
		}
		case "prepare": {
			rs = orderRepository.getOrderByCurrentStatus(status, pageable);
			break;
		}
		case "delivery": {
			rs = orderRepository.getOrderByCurrentStatus(status, pageable);
			break;
		}
		case "received": {
			rs = orderRepository.getOrderByCurrentStatus(status, pageable);
			break;
		}
		default:
			System.out.println("Invalid status");
			break;
		}
		return rs;
	}

	public Order updateNewStatusOrder(Order order) {
		System.out.println("Order Service - Update New Status Order");
		System.out.println("Data Init: " + order);
		Order rs = orderRepository.findById(new IDOrder(order.getIdOrder(), order.getIdUser())).orElseThrow();
		rs.setCurrentStatus(order.getCurrentStatus());

		System.out.println("Data Result: " + rs);
		return orderRepository.saveAndFlush(rs);
	}

	public Optional<Order> getOrder(Order order) {
		return orderRepository.findById(new IDOrder(order.getIdOrder(), order.getIdUser()));
	}

	public Order getOrderByID(Order order) {
		System.out.println("Order Service - Get Order By ID");
		Order rs = null;
		try {
			rs = orderRepository.getOrdersByIDOrder(order.getIdOrder());
		} catch (Exception e) {
			// TODO: handle exception
			// Ghi log lỗi thay vì in ra console
//			LoggerFactory.getLogger(OrderService.class).error("Error fetching order by ID: ", e);
			// Ném lại ngoại lệ hoặc xử lý theo cách khác
			throw new RuntimeException("Unable to fetch order", e);
		}
		return rs;
	}
	
	public List<Object[]> countOrdersByStatus(){
		System.out.println("Order Service - Count Order By Status");
		return orderRepository.countOrdersByStatus();
	}

}
