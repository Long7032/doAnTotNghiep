package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IDOrderStatus;
import com.example.demo.entity.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, IDOrderStatus>{

	//	==========	Get The Current Status Order	==========
	@Query("SELECT os FROM OrderStatus os WHERE os.idOrder = ?1 ORDER BY os.time desc")
	public List<OrderStatus> getTheCurrentStatusOrder(String id, Pageable page);
}
