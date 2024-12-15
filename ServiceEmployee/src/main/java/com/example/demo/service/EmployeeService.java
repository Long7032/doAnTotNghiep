package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		System.out.println("Employee Service - Save Employee");
		Employee rs = null;
		try {
			employee.setHiredDate(LocalDateTime.now());
			rs = employeeRepository.save(employee);
		} catch (Exception e) {
			System.err.println("Error saving employee: " + e.getMessage());
		}
		return rs;
	}

	public List<Employee> getEmployeesByPage(int page, int size) {
		try {
			Pageable pageable = PageRequest.of(page - 1, size);
			return employeeRepository.getListEmployeeByPage(pageable);
		} catch (Exception e) {
			System.err.println("Error retrieving employees by page: " + e.getMessage());
			return new ArrayList<>();
		}
	}

	public Employee getEmployeeByID(String id) {
		try {
			return employeeRepository.findById(id).orElseThrow();
		} catch (Exception e) {
			System.err.println("Error retrieving employee by ID: " + e.getMessage());
			return null;
		}
	}

	public List<Employee> getEmployees() {
		try {
			return employeeRepository.findAll();
		} catch (Exception e) {
			System.err.println("Error retrieving all employees: " + e.getMessage());
			return new ArrayList<>();
		}
	}

	public boolean deleteEmployee(String id) {
		try {
			employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));
			employeeRepository.deleteById(id);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println("Employee not found: " + e.getMessage());
			return false;
		} catch (Exception e) {
			System.err.println("Error deleting employee: " + e.getMessage());
			return false;
		}
	}

	public boolean updateEmployee(Employee e) {
		System.out.println("Employee Service Update");
		System.out.println("Data Init: " + e);
		try {
			if (e != null) {
				employeeRepository.saveAndFlush(e);
				return true;
			}
		} catch (Exception ex) {
			System.err.println("Error updating employee: " + ex.getMessage());
		}
		return false;
	}

}
