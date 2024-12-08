package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IDOrder;
import com.example.demo.entity.Order;

import jakarta.transaction.Transactional;

public interface OrderRepository extends JpaRepository<Order, IDOrder> {

	@Transactional
	@Query("select o from Order o where o.idUser = ?1")
	public List<Order> getOrdersByUser(String id);

	@Transactional
	@Query("SELECT o FROM Order o")
	public List<Order> getOrderInRange(Pageable pageable);

	@Transactional
	@Query("Update Order o Set o.currentStatus = ?2 where o.idOrder = ?1")
	public Order updateStatusOrder(String idOrder, String newStatus);

	@Transactional
	@Query("select o from Order o where o.idOrder = ?1")
	public Order getOrdersByIDOrder(String id);

	@Transactional
	@Query("Select o from Order o where o.currentStatus = ?1")
	public List<Order> getOrderByCurrentStatus(String status, Pageable pageable);

	@Transactional
	@Query("SELECT o.currentStatus, COUNT(o.idOrder) FROM Order o GROUP BY o.currentStatus ORDER BY	o.currentStatus desc")
	public List<Object[]> countOrdersByStatus();

	@Transactional
	@Query("SELECT DATE(o.dateTime),COUNT(o.idOrder) FROM Order o WHERE DATE(o.dateTime) = DATE(?1) GROUP BY DATE(o.dateTime)")
	public List<Object[]> countOrderByDateTime(LocalDateTime time);
	
	//	=====	-----	Statistic	=====	-----
	
	//	Thống Kê Tổng Số Hóa Đơn Theo Thời Gian
	@Transactional
	@Query("SELECT DATE(o.dateTime), COUNT(o.idOrder) FROM Order o WHERE DATE(o.dateTime) BETWEEN DATE(?1) AND DATE(?2) GROUP BY DATE(o.dateTime)")
	public List<Object[]> getTotalOrderByDate(LocalDateTime start, LocalDateTime end);
	
	// 	Thống Kê Tổng Số Hóa Đơn Trong Khoảng Thời Gian
	@Transactional
	@Query("SELECT COUNT(o.idOrder) FROM Order o WHERE DATE(o.dateTime) BETWEEN DATE(?1) AND DATE(?2)")
	public List<Object[]> getTotalOrdersByDate(LocalDateTime start, LocalDateTime end);
	
	//	Thống Kê Tổng Số Hóa Đơn Theo Trạng Thái Theo Thời Gian
	@Transactional
	@Query("SELECT o.currentStatus, COUNT(o.idOrder) FROM Order o WHERE DATE(o.dateTime) BETWEEN DATE(?1) AND DATE(?2) GROUP BY o.currentStatus")
	public List<Object[]> getOrderByStatusDate(LocalDateTime start, LocalDateTime end);
	
	//	Lấy Danh Sách Mã Hóa Đơn Theo Thời Gian
}
