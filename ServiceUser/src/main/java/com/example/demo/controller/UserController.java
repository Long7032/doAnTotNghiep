package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> getUser(@PathVariable String id) {
		System.out.println("User Controller - Get User By ID");

		try {
			User user = userService.getUser(id);
			if (user != null) {
				return ResponseEntity.status(200).body(user);
			} else {
				return ResponseEntity.status(404).body("User Not Found");
			}
		} catch (Exception e) {
			System.err.println("Error occurred while getting user: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@GetMapping("/name/{type}/{name}/{page}/{size}")
	public ResponseEntity<Object> getUsersByName(@PathVariable String type, @PathVariable String name,
			@PathVariable int page, @PathVariable int size) {
		System.out.println("User Controller - Get Users By Name");

		try {
			List<User> users = userService.getUserByNameInRange(type, name, page, size);
			if (users != null && !users.isEmpty()) {
				return ResponseEntity.status(200).body(users);
			} else {
				return ResponseEntity.status(404).body("User Not Found");
			}
		} catch (Exception e) {
			System.err.println("Error occurred while getting users by name: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@PostMapping("/")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		System.out.println("User Controller - Save User");

		try {
			User savedUser = userService.saveUser(user);
			if (savedUser != null) {
				return ResponseEntity.status(200).body(savedUser);
			} else {
				return ResponseEntity.status(400).body("Fail");
			}
		} catch (Exception e) {
			System.err.println("Error occurred while saving user: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@PutMapping("/")
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		System.out.println("User Controller - Update User");

		try {
			User updatedUser = userService.updateUser(user);
			if (updatedUser != null) {
				return ResponseEntity.status(200).body(updatedUser);
			} else {
				return ResponseEntity.status(400).body("Fail");
			}
		} catch (Exception e) {
			System.err.println("Error occurred while updating user: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@PatchMapping("/{type}")
	public ResponseEntity<Object> updateRoleUser(@PathVariable String type, @RequestBody User user) {
		System.out.println("User Controller - Update Role User");

		try {
			User updatedUser = userService.updateRoleForUser(user, type);
			if (updatedUser != null) {
				return ResponseEntity.status(200).body(updatedUser);
			} else {
				return ResponseEntity.status(500).body("Fail");
			}
		} catch (Exception e) {
			System.err.println("Error occurred while updating role for user: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@DeleteMapping("/")
	public ResponseEntity<Object> deleteUser(@RequestBody User user) {
		System.out.println("User Controller - Delete User");

		try {
			User isDeleted = userService.deleteUser(user);
			return ResponseEntity.status(200).body(isDeleted);
		} catch (Exception e) {
			System.err.println("Error occurred while deleting user: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@GetMapping("/number/{type}")
	public ResponseEntity<Object> getUsersByType(@PathVariable String type) {
		System.out.println("User Controller - Get Users By Type");

		try {
			List<User> users = userService.getUsersByType(type);
			return ResponseEntity.status(200).body(users);
		} catch (Exception e) {
			System.err.println("Error occurred while getting users by type: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@GetMapping("/list/employee/{type}/{page}/{size}")
	public ResponseEntity<Object> getUsersByRoleAndStatusInRange(@PathVariable String type, @PathVariable int page,
			@PathVariable int size) {
		System.out.println("User Controller - Get Users By Role Employee And Type In Range");

		try {
			List<User> users = userService.getUserByEmployeeRoleInRange(type, page, size);
			return ResponseEntity.status(200).body(users);
		} catch (Exception e) {
			System.err.println("Error occurred while getting users by role and status in range: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@GetMapping("/{type}/{page}/{size}")
	public ResponseEntity<Object> getListUsers(@PathVariable String type, @PathVariable int page,
			@PathVariable int size) {
		System.out.println("User Controller - Get Users By Type In Range");

		try {
			List<User> users = userService.getUserInRange(type, page, size);
			return ResponseEntity.status(200).body(users);
		} catch (Exception e) {
			System.err.println("Error occurred while getting list of users: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

	@PostMapping("/time-count-user")
	public ResponseEntity<Object> countUserByTime(@RequestBody User u) {
		System.out.println("User Controller - Count Users By Time");

		try {
			List<Object[]> userCount = userService.countUserByTime(u);
			return ResponseEntity.status(200).body(userCount);
		} catch (Exception e) {
			System.err.println("Error occurred while counting users by time: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}


	
	@DeleteMapping("/reset-service")
	public ResponseEntity<Object> resetService() {
		System.out.println("User Controller - Reset Service");

		try {
			userService.resetService();
			return ResponseEntity.status(200).body("Reset Service Success");
		} catch (Exception e) {
			System.err.println("Error occurred while resetting service: " + e.getMessage());
			return ResponseEntity.status(500).body("Internal Server Error");
		}
	}

}
