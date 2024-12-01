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
		try {
			user.setRole("2");
			rs = userRepository.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return rs;
	}

	public void resetService() {
		System.out.println("User Service - Delete All Data In Service");
		userRepository.deleteAll();
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
		User rs = userRepository.findById(user.getId()).orElseThrow();

		// Don't change this user data
		user.setTimeCreate(rs.getTimeCreate());
		user.setShoppingPoint(rs.getShoppingPoint());

		return userRepository.saveAndFlush(user);
	}

	public User updateRoleForUser(User user, String option) {
		System.out.println("User Service - Update Role User");
		// Get User By ID
		User rs = userRepository.findById(user.getId()).orElseThrow();

		if (option.equals("upgrade")) {
			rs.setRole("1");
		} else if (option.equals("degrade")) {
			rs.setRole("2");
		}
		System.out.println(rs);
		return userRepository.saveAndFlush(rs);
	}

	public List<User> getUserInRange(String type, int page, int size) {
		System.out.println("User Service -  Get Users By Status In Range");
		Pageable pageable = PageRequest.of(page - 1, size);

		switch (type) {
		case "all": {
			return userRepository.getUsersInRange(pageable);
		}
		case "active": {
			return userRepository.getUsersInByStatusRange(pageable, type);
		}
		case "inactive": {
			return userRepository.getUsersInByStatusRange(pageable, type);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

	}

	public List<User> getUserByEmployeeRoleInRange(String type, int page, int size) {
		System.out.println("User Service -  Get Users By Employee Role And Page");
		Pageable pageable = PageRequest.of(page - 1, size);
		switch (type) {
		case "all": {
			return userRepository.getUsersByEmployeeRoleInRange(pageable);
		}
		case "active": {
			return userRepository.getUsersByEmployeeRoleAndStatusInRange(pageable, type);
		}
		case "inactive": {
			return userRepository.getUsersByEmployeeRoleAndStatusInRange(pageable, type);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
	}

	public List<User> getUsersByType(String type) {
		System.out.println("User Service - Get All Users By Type");
		switch (type) {
		case "all": {
			return userRepository.findAll();
		}
		case "active": {
			return userRepository.getUsersByStatus(type);
		}
		case "inactive": {
			return userRepository.getUsersByStatus(type);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

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
