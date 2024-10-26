package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
		// Generate ID Employee Automatic
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

		SimpleDateFormat sdf1 = new SimpleDateFormat("HHmmss");

		Random random = new Random();
		int randomValue = 100000 + random.nextInt(900000);

		String id = sdf.format(new Date()) + String.valueOf(randomValue) + sdf1.format(new Date());

		employee.setId(id);

		return employeeRepository.save(employee);
	}

	public List<Employee> getEmployeesByPage(int page, int size) {
		Pageable pageable =  PageRequest.of(page - 1, size);
		return employeeRepository.getListEmployeeByPage(pageable);
	}
	
	public Optional<Employee> getEmployeeByID(String id) {
		return employeeRepository.findById(id);
	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public boolean deleteEmployee(String id) {
		Employee e = null;
		e = employeeRepository.getById(id);
		if (e != null) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean updateEmployee(Employee e) {
		System.out.println("Employee Service Update");
		System.out.println("Data Init: " + e);

		if (e != null) {
			employeeRepository.saveAndFlush(e);
			return true;
		}
		return false;
	}

}
