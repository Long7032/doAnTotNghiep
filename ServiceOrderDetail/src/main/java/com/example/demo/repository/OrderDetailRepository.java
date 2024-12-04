package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IDOrderDetail;
import com.example.demo.entity.OrderDetail;

import jakarta.transaction.Transactional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, IDOrderDetail> {

	@Modifying
	@Transactional
	@Query("SELECT od.idOrder, SUM(od.quantity * (od.price - od.pricePromotion)) FROM OrderDetail od WHERE od.idOrder = ?1 GROUP BY od.idOrder")
	public List<Object[]> calculatorOrder(String id);

	@Modifying
	@Transactional
	@Query("SELECT od FROM OrderDetail od WHERE od.idOrder = ?1")
	public List<OrderDetail> getOrderDetailsByOrderID(String id);

	@Modifying
	@Transactional
	@Query("DELETE FROM OrderDetail od WHERE od.idOrder = ?1")
	public void deleteAllOrderDetailByOrderID(String id);

	@Transactional
	@Query("SELECT od.idProduct, SUM(od.quantity) AS totalQuantity FROM OrderDetail od GROUP BY od.idProduct ORDER BY totalQuantity DESC")
	public List<Object[]> getTopProductBestSelling();
}
