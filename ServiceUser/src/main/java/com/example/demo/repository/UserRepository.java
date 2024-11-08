package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Query("select u from User u where u.email = ?1")
	public User getUser(String email);
	
	@Query("SELECT u FROM User u")
	public List<User> getUsersInRange(Pageable pageable);
	
	@Query("SELECT u FROM User u WHERE u.role = '2'")
	public List<User> getUsersByEmployeeRoleInRange(Pageable pageable);
	
}
