package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	@Query("update Employee e set e.status = ?1")
	public boolean setInactiveEmployee(String id);
}
