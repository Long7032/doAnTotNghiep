
package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderStatus;
import com.example.demo.repository.OrderStatusRepository;

@Service
public class OrderStatusService {
	@Autowired
	private OrderStatusRepository orderStatusRepository;

	public OrderStatus saveOrderStatus(OrderStatus orderStatus) {
		System.out.println("Order Status Service - Save Order Status");

		OrderStatus rs = null;
		// Find The Current Status Order
		Pageable pageable = PageRequest.of(0, 1);
		List<OrderStatus> list = orderStatusRepository.getTheCurrentStatusOrder(orderStatus.getIdOrder(), pageable);
//
		OrderStatus os = new OrderStatus();
		if (list.toArray().length == 0) {
			os.setStatus("");
		} else {
			os = list.get(0);
		}
		System.out.println("Result From List: " + os);
		if (os.getStatus().equals("")) {
			orderStatus.setTime(LocalDateTime.now());
			rs = orderStatusRepository.save(orderStatus);

		} else {
			switch (os.getStatus()) {
			case "create": {
				if (orderStatus.getStatus().equals("prepare") || orderStatus.getStatus().equals("cancel")) {
					orderStatus.setTime(LocalDateTime.now());
					rs = orderStatusRepository.save(orderStatus);
				}
				break;
			}
			case "prepare": {
				if (orderStatus.getStatus().equals("delivery") || orderStatus.getStatus().equals("cancel")) {
					orderStatus.setTime(LocalDateTime.now());
					rs = orderStatusRepository.save(orderStatus);
				}
				break;
			}
			case "delivery": {
				if (orderStatus.getStatus().equals("delivered") || orderStatus.getStatus().equals("cancel")) {
					orderStatus.setTime(LocalDateTime.now());
					rs = orderStatusRepository.save(orderStatus);
				}
				break;
			}
			case "delivered": {
				if (orderStatus.getStatus().equals("done")) {
					orderStatus.setTime(LocalDateTime.now());
					rs = orderStatusRepository.save(orderStatus);
				}
				break;
			}
			case "done": {

				break;
			}
			case "cancel": {
				rs = null;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + os.getStatus());
			}
		}
		;

		return rs;

	}

	public List<OrderStatus> getOrderStatussByID(OrderStatus orderStatus) {
		System.out.println("Order Status Service - Get Order Status By ID");
		System.out.println("Data Init: " + orderStatus);
		return orderStatusRepository.getAllStatusOrderByID(orderStatus.getIdOrder());
	}

	public List<OrderStatus> getOrderStatusByIDAndStatus(OrderStatus orderStatus) {
		System.out.println("Order Status Service - Get Order Status By ID");
		System.out.println("Data Init: " + orderStatus);
		return orderStatusRepository.getStatusOrderByIDAndStatus(orderStatus.getIdOrder(), orderStatus.getStatus());
	}

	public List<OrderStatus> getOrderStatuss() {
		// TODO Auto-generated method stub
		System.out.println("Order Status Service - Get All Order Status");
		return orderStatusRepository.findAll();
	}
	
	public List<OrderStatus> getOrderWithDeliveredStatus(OrderStatus orderStatus){
		System.out.println("Order Status Service - Get Order Status With Delivered Status");
		System.out.println("Data Init: " + orderStatus);
		return orderStatusRepository.getOrderWithDeliveredStatus(orderStatus.getTime());
		
	}
}
