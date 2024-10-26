package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getEmployeeByID(@PathVariable String id) {
		Optional<Employee> rs = employeeService.getEmployeeByID(id);
		return ResponseEntity.status(200).body(rs);
	}

	@GetMapping("/number")
	public ResponseEntity<Object> getNumberOfEmployees() {
		int length = employeeService.getEmployees().toArray().length;
		return ResponseEntity.status(200).body(length);
	}

	@GetMapping("/{page}/{size}")
	public ResponseEntity<Object> getEmployeesByPage(@PathVariable int page, @PathVariable int size) {
		List<Employee> list = employeeService.getEmployeesByPage(page, size);
		return ResponseEntity.status(200).body(list);
	}

	@PostMapping("/")
	public Employee saveEmployees(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/")
	public boolean updateEmpoyee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public boolean deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(id);
	}
}
