package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		try {
			// Generate Order ID
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Random random = new Random();
			int randomValue = 100000 + random.nextInt(900000);

			String id = "HD" + sdf.format(new Date()) + String.valueOf(randomValue);
			order.setIdOrder(id);

			return orderRepository.save(order);
		} catch (Exception e) {
			System.err.println("An error occurred while saving the order: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public List<Order> getOrdersByUser(String id) {
		System.out.println("Order Service - Get Orders By User");
		try {
			return orderRepository.getOrdersByUser(id);
		} catch (Exception e) {
			System.err.println("An error occurred while fetching orders by user: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<Order> getOrderInRange(int page, int size) {
		System.out.println("Order Service - Get Orders In Range");
		Pageable pageable = PageRequest.of(page - 1, size);
		try {
			return orderRepository.getOrderInRange(pageable);
		} catch (Exception e) {
			System.err.println("An error occurred while fetching orders in range: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<Order> getOrderByCurrentStatusInRange(String status, int page, int size) {
		System.out.println("Order Service - Get Order By Current Status In Range");
		System.out.println("Data Init - Status: " + status);

		Pageable pageable = PageRequest.of(page - 1, size);
		List<Order> rs = null;

		try {
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
			case "delivered": {
				rs = orderRepository.getOrderByCurrentStatus(status, pageable);
				break;
			}
			case "done": {
				rs = orderRepository.getOrderByCurrentStatus(status, pageable);
				break;
			}
			default:
				System.out.println("Invalid status");
				break;
			}
		} catch (Exception e) {
			System.err.println("An error occurred while fetching orders by status: " + e.getMessage());
			e.printStackTrace();
		}

		return rs;
	}

	public Order updateNewStatusOrder(Order order) {
		System.out.println("Order Service - Update New Status Order");
		System.out.println("Data Init: " + order);

		try {
			Order rs = orderRepository.findById(new IDOrder(order.getIdOrder(), order.getIdUser())).orElseThrow();
			rs.setCurrentStatus(order.getCurrentStatus());

			System.out.println("Data Result: " + rs);
			return orderRepository.saveAndFlush(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while updating the order status: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Order getOrderByIdUserAndIdOrder(Order order) {
		try {
			System.out.println("Order Service - Get Order");
			return orderRepository.findById(new IDOrder(order.getIdOrder(), order.getIdUser())).orElse(null);
		} catch (Exception e) {
			System.err.println("An error occurred while fetching the order: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Order getOrderByID(Order order) {
		System.out.println("Order Service - Get Order By ID");
		Order rs = null;
		try {
			rs = orderRepository.getOrdersByIDOrder(order.getIdOrder());
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Unable to fetch order", e);
		}
		return rs;
	}

	public List<Object[]> countOrdersByStatus() {
		System.out.println("Order Service - Count Order By Status");
		try {
			return orderRepository.countOrdersByStatus();
		} catch (Exception e) {
			System.err.println("An error occurred while counting orders by status: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<Object[]> countOrdersByTime(LocalDateTime time) {
		System.out.println("Order Service - Count Order By Time");
		try {
			return orderRepository.countOrderByDateTime(time);
		} catch (Exception e) {
			System.err.println("An error occurred while counting orders by time: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<Object[]> countOrdersInRangeTime(LocalDateTime start, LocalDateTime end) {
		System.out.println("Order Service - Count Order In Range");
		System.out.println("Data Init");
		System.out.println(start);
		System.out.println(end);
		try {
			System.out.println(orderRepository.getTotalOrderByDate(start, end).get(0));
			return orderRepository.getTotalOrderByDate(start, end);
		} catch (Exception e) {
			System.err.println("An error occurred while counting orders in range: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public List<Object[]> countTotalOrdersInRangeTime(LocalDateTime start, LocalDateTime end) {
		System.out.println("Order Service - Count Total Order In Range");
		System.out.println("Data Init");
		System.out.println(start);
		System.out.println(end);
		try {
			System.out.println(orderRepository.getTotalOrdersByDate(start, end).get(0));
			return orderRepository.getTotalOrdersByDate(start, end);
		} catch (Exception e) {
			System.err.println("An error occurred while counting orders in range: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	public List<Object[]> countTotalOrdersByStatusInRangeTime(LocalDateTime start, LocalDateTime end) {
		System.out.println("Order Service - Count Status Order In Range");
		System.out.println("Data Init");
		System.out.println(start);
		System.out.println(end);
		try {
			System.out.println(orderRepository.getOrderByStatusDate(start, end).get(0));
			return orderRepository.getOrderByStatusDate(start, end);
		} catch (Exception e) {
			System.err.println("An error occurred while counting orders in range: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
