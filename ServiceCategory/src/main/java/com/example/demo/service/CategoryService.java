package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category getCategory(String name) {
		return categoryRepository.getCaterory(name);
	}
	
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public boolean updateCategory(String oldName, String newName) {
		Category category = null;
		category = categoryRepository.getCaterory(oldName);
		if (category != null) {
			category.setName(newName);
			categoryRepository.saveAndFlush(category);
			return true;
		}
		return false;
	}
	
	public boolean deleteCategory(String name) {
		Category category = null;
		category = categoryRepository.getCaterory(name);
		if (category != null) {
			categoryRepository.delete(category);
			return true;
		}
		return false;
	}
}
