package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.IDOrderStatus;
import com.example.demo.entity.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, IDOrderStatus>{

}
