package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<Object> getEmployees() {
		try {
			List<Employee> employees = employeeService.getEmployees();
			return ResponseEntity.status(200).body(employees);
		} catch (Exception e) {
			System.err.println("An error occurred while getting employees: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getEmployeeByID(@PathVariable String id) {
		try {
			Employee rs = employeeService.getEmployeeByID(id);
			return ResponseEntity.status(200).body(rs);
		} catch (NoSuchElementException e) {
			System.err.println("Employee not found: " + e.getMessage());
			return ResponseEntity.status(404).body("Employee not found");
		} catch (Exception e) {
			System.err.println("An error occurred while getting the employee by ID: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@GetMapping("/number")
	public ResponseEntity<Object> getNumberOfEmployees() {
		try {
			int length = employeeService.getEmployees().size();
			return ResponseEntity.status(200).body(length);
		} catch (Exception e) {
			System.err.println("An error occurred while getting the number of employees: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@GetMapping("/{page}/{size}")
	public ResponseEntity<Object> getEmployeesByPage(@PathVariable int page, @PathVariable int size) {
		try {
			List<Employee> list = employeeService.getEmployeesByPage(page, size);
			return ResponseEntity.status(200).body(list);
		} catch (Exception e) {
			System.err.println("An error occurred while getting employees by page: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@PostMapping("/")
	public ResponseEntity<Object> saveEmployees(@RequestBody Employee employee) {
		System.out.println("Employee Controller - Save Employee");
		try {
			Employee rs = employeeService.saveEmployee(employee);
			return ResponseEntity.status(200).body(rs);
		} catch (Exception e) {
			System.err.println("An error occurred while saving the employee: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@PutMapping("/")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		try {
			boolean updated = employeeService.updateEmployee(employee);
			if (updated) {
				return ResponseEntity.status(200).body("Employee updated successfully");
			} else {
				return ResponseEntity.status(400).body("Update failed");
			}
		} catch (Exception e) {
			System.err.println("An error occurred while updating the employee: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id) {
		try {
			boolean deleted = employeeService.deleteEmployee(id);
			if (deleted) {
				return ResponseEntity.status(200).body("Employee deleted successfully");
			} else {
				return ResponseEntity.status(404).body("Employee not found");
			}
		} catch (Exception e) {
			System.err.println("An error occurred while deleting the employee: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

}
