package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IDOrder;
import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, IDOrder>{
	@Query("select o from Order o where o.idUser = ?1")
	public List<Order> getOrdersByUser(String id);
	
	@Query("SELECT o FROM Order o")
	public List<Order> getOrderInRange(Pageable pageable);
	
	@Query("Update Order o Set o.currentStatus = ?2 where o.idOrder = ?1")
	public Order updateStatusOrder(String idOrder, String newStatus);
	
	@Query("select o from Order o where o.idOrder = ?1")
	public Order getOrdersByIDOrder(String id);
	
	@Query("Select o from Order o where o.currentStatus = ?1")
	public List<Order> getOrderByCurrentStatus(String status, Pageable pageable);
	
	@Query("SELECT o.currentStatus, COUNT(o.idOrder) FROM Order o GROUP BY o.currentStatus ORDER BY	o.currentStatus desc")
	public List<Object[]> countOrdersByStatus(); 
}
