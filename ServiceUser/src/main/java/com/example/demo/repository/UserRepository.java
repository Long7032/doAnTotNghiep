package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, String> {
	@Transactional
	@Query("select u from User u where u.email = ?1")
	public User getUser(String email);

	@Transactional
	@Query("SELECT u FROM User u")
	public List<User> getUsersInRange(Pageable pageable);

	@Transactional
	@Query("SELECT u FROM User u WHERE u.status = ?1")
	public List<User> getUsersByStatus(String status);

	@Transactional
	@Query("SELECT u FROM User u WHERE u.status = ?1")
	public List<User> getUsersInByStatusRange(Pageable pageable, String status);

	@Transactional
	@Query("SELECT COUNT(u.id) FROM User u WHERE DATE(u.timeCreate) = DATE(?1) GROUP BY DATE(u.timeCreate)")
	public List<Object[]> countUserByTime(LocalDateTime time);

	// ===== ***** ===== ***** Employee ===== ***** ===== *****
	@Transactional
	@Query("SELECT u FROM User u WHERE u.role = '2'")
	public List<User> getUsersByEmployeeRoleInRange(Pageable pageable);

	@Transactional
	@Query("SELECT u FROM User u WHERE u.role = '2'	AND u.status = ?1")
	public List<User> getUsersByEmployeeRoleAndStatusInRange(Pageable pageable, String status);
}
