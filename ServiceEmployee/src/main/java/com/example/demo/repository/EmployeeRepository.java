package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	@Query("update Employee e set e.status = ?1")
	public boolean setInactiveEmployee(String id);

	@Query("Select e From Employee e")
	public List<Employee> getListEmployeeByPage(Pageable pageable);
}
