package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		System.out.println("User Service - Save User");
		User rs = null;
		rs = userRepository.save(user);
		return rs;
	}

	public Optional<User> deleteUser(User user) {
		System.out.println("User Service - Delete User");
		
		userRepository.deleteById(user.getId());
		// Get User By ID And Check User Deleted
		return userRepository.findById(user.getId());
	}

	public User updateUser(User user) {
		System.out.println("User Service - Update User");
		// Get User By ID
		User rs = userRepository.getById(user.getId());

		// Don't change this user data
		user.setTimeCreate(rs.getTimeCreate());
		user.setShoppingPoint(rs.getShoppingPoint());

		return userRepository.saveAndFlush(user);
	}
	
	public User updateRoleForUser(User user, String option) {
		System.out.println("User Service - Update Role User");
		// Get User By ID
		User rs = userRepository.findById(user.getId()).orElseThrow();

		if(option.equals("upgrade")) {
			rs.setRole("1");
		} else if(option.equals("degrade")) {
			rs.setRole("2");
		}
		System.out.println(rs);
		return userRepository.saveAndFlush(rs);
	}

	public List<User> getUserInRange(int page, int size) {
		System.out.println("User Service -  Get Users By Page");
		Pageable pageable = PageRequest.of(page - 1, size);
		return userRepository.getUsersInRange(pageable);
	}

	public List<User> getUserByEmployeeRoleInRange(int page, int size) {
		System.out.println("User Service -  Get Users By Employee Role And Page");
		Pageable pageable = PageRequest.of(page - 1, size);
		return userRepository.getUsersByEmployeeRoleInRange(pageable);
	}
	
	public List<User> getUsers() {
		System.out.println("User Service - Get All Users");
		return userRepository.findAll();
	}

	public User getUserByEmail(String email) {
		System.out.println("User Service -  Get Users By Email");
		System.out.println(email);
		User user = null;
		user = userRepository.getUser(email);
		return user;
	}

	public Optional<User> getUser(String id) {
		System.out.println("User Service -  Get Users By ID");
		return userRepository.findById(id);
	}
	
}
