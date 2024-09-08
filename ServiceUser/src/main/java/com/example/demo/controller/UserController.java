package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{email}")
	public User getUser(@PathVariable String email) {
		System.out.println(email);
		return userService.getUser(email);
	}

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		// TODO: process POST request

		return userService.saveUser(user);
	}

	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		// TODO: process POST request

		return userService.saveUser(user);
	}

	@DeleteMapping("/")
	public void deleteUser(@RequestBody User user) {
		// TODO: process POST request

		userService.saveUser(user);
	}

	@GetMapping("/")
	public List<User> getUsers() {
		return userService.getUsers();
	}

}
