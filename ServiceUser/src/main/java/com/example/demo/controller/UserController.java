package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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
		
		Optional<User> user = userService.getUser(id);
		if (user != null) {
			return ResponseEntity.status(200).body(user);
		}
		return ResponseEntity.status(400).body(new String("User Not Found"));
	}

	@PostMapping("/")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		System.out.println("User Controller - Save User");
		// TODO: process POST request
		System.out.println(user);
//		return ResponseEntity.status(500).body(userService.saveUser(user));
		if (userService.saveUser(user) == null) {
			return ResponseEntity.status(500).body(new String("Fail"));
		}
		return ResponseEntity.status(200).body(userService.saveUser(user));
	}

	@PutMapping("/")
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		System.out.println("User Controller - Update User");
		System.out.println(user);
//		return ResponseEntity.status(500).body(.saveUser(user));userService
		User rs = userService.updateUser(user);
		if (userService.updateUser(user) == null) {
			return ResponseEntity.status(500).body(new String("Fail"));
		}
		return ResponseEntity.status(200).body(rs);
	}
	@PatchMapping("/{type}")
	public ResponseEntity<Object> updateRoleUser(@PathVariable String type, @RequestBody User user) {
		System.out.println("User Controller - Update Role User");
		System.out.println(user);
//		return ResponseEntity.status(500).body(userService.saveUser(user));
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

	@GetMapping("/number")
	public double getUsers() {
		return userService.getUsers().toArray().length;
	}

	@GetMapping("/list/employee/{page}/{size}")
	public List<User> getListUsers(@PathVariable int page, @PathVariable int size) {
		System.out.println("User Controller - Get User By Page");
		return userService.getUserInRange(page, size);
	}
	@GetMapping("/{page}/{size}")
	public List<User> getListUsersByEmployeeRole(@PathVariable int page, @PathVariable int size) {
		System.out.println("User Controller - Get User By Employee Role And Page");
		return userService.getUserInRange(page, size);
	}
}
