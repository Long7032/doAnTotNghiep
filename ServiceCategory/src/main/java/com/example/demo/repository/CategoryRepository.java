package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

	@Query("select c from Category c where c.name = ?1")
	public Category getCaterory(String name);
	
	@Query("SELECT c FROM Category c")
	public List<Category> getCategoryInRange(Pageable pageable);
	
	
	@Query("SELECT c FROM Category c where c.status = 'active'")
	public List<Category> getCategoryInRangeActive(Pageable pageable);
}
