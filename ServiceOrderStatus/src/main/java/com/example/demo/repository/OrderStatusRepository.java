package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IDOrderStatus;
import com.example.demo.entity.OrderStatus;

import jakarta.transaction.Transactional;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, IDOrderStatus> {

	// ========== Get The Current Status Order ==========
	@Transactional
	@Query("SELECT os FROM OrderStatus os WHERE os.idOrder = ?1 ORDER BY os.time desc")
	public List<OrderStatus> getTheCurrentStatusOrder(String id, Pageable page);

	@Transactional
	@Query("SELECT os FROM OrderStatus os WHERE os.idOrder = ?1")
	public List<OrderStatus> getAllStatusOrderByID(String id);

	@Transactional
	@Query("SELECT os FROM OrderStatus os WHERE os.idOrder = ?1 and os.status = ?2")
	public List<OrderStatus> getStatusOrderByIDAndStatus(String id, String status);

	@Transactional
	@Query("SELECT os FROM OrderStatus os WHERE os.status = 'delivered' AND DATE(os.time) = DATE(?1)")
	public List<OrderStatus> getOrderWithDeliveredStatus(LocalDateTime time);
}
