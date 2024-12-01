package com.example.demo.controller;

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

		User user = userService.getUser(id).orElseThrow();
		if (user != null) {
			return ResponseEntity.status(200).body(user);
		}
		return ResponseEntity.status(400).body(new String("User Not Found"));
	}

	@PostMapping("/")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		System.out.println("User Controller - Save User");
		// TODO: process POST request
		if (userService.saveUser(user) == null) {
			return ResponseEntity.status(400).body(new String("Fail"));
		}
		return ResponseEntity.status(200).body(userService.saveUser(user));
	}

	@PutMapping("/")
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		System.out.println("User Controller - Update User");
		System.out.println(user);
		User rs = userService.updateUser(user);
		if (userService.updateUser(user) == null) {
			return ResponseEntity.status(400).body(new String("Fail"));
		}
		return ResponseEntity.status(200).body(rs);
	}

	@PatchMapping("/{type}")
	public ResponseEntity<Object> updateRoleUser(@PathVariable String type, @RequestBody User user) {
		System.out.println("User Controller - Update Role User");
		System.out.println(user);
		User rs = userService.updateRoleForUser(user, type);
		if (rs == null) {
			return ResponseEntity.status(500).body(new String("Fail"));
		}
		return ResponseEntity.status(200).body(rs);
	}

	@DeleteMapping("/")
	public ResponseEntity<Object> deleteUser(@RequestBody User user) {
		// TODO: process POST request
		System.out.println("User Controller - Delete User");
		return ResponseEntity.status(200).body(userService.deleteUser(user));
	}

	@GetMapping("/number/{type}")
	public ResponseEntity<Object> getUsersByType(@PathVariable String type) {
		System.out.println("User Controller - Get Users By Type");
		return ResponseEntity.status(200).body(userService.getUsersByType(type));
	}

	@GetMapping("/list/employee/{type}/{page}/{size}")
	public ResponseEntity<Object> getUsersByRoleAndStatusInRange(@PathVariable String type, @PathVariable int page,
			@PathVariable int size) {
		System.out.println("User Controller - Get Users By Role Employee And Type In Range");
		return ResponseEntity.status(200).body(userService.getUserByEmployeeRoleInRange(type, page, size));
	}

	@GetMapping("/{type}/{page}/{size}")
	public ResponseEntity<Object> getListUsers(@PathVariable String type, @PathVariable int page,
			@PathVariable int size) {
		System.out.println("User Controller - Get Users By Type In Range");
		return ResponseEntity.status(200).body(userService.getUserInRange(type, page, size));
	}

	@PostMapping("/time-count-user")
	public ResponseEntity<Object> countUserByTime(@RequestBody User u) {
		System.out.println("User Controller - Count Users By Time");
		return ResponseEntity.status(200).body(userService.countUserByTime(u));
	}

	@DeleteMapping("/reset-service")
	public ResponseEntity<Object> resetService() {
		System.out.println("User Controller - Reset Service");
		userService.resetService();
		return ResponseEntity.status(200).body(new String("Reset Service Success"));
	}
}
