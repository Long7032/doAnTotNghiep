package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	@PostMapping("/")
	public Employee saveEmployees(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PatchMapping("/{id}")
	public boolean inactiveStatusEmployee(@PathVariable String id) {
		return employeeService.inactiveStatusEmployee(id);
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
