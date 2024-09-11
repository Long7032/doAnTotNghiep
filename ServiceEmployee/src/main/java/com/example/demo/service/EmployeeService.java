package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@SuppressWarnings("deprecation")
	public Employee getEmployee(String id) {
		return employeeRepository.getById(id);
	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public boolean inactiveStatusEmployee(String id) {
		Employee e = null;
		e = getEmployee(id);
		if (e != null) {
			e.setStatus("Inactive");
			employeeRepository.saveAndFlush(e);
			return true;
		}
		return false;
	}

	public boolean deleteEmployee(String id) {
		Employee e = null;
		e = getEmployee(id);
		if (e != null) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean updateEmployee(Employee e) {
		if (e != null) {
			employeeRepository.saveAndFlush(e);
			return true;
		}
		return false;
	}

}
