package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	public List<Category> getCategoriesInRange(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return categoryRepository.getCategoryInRange(pageable);
	}
	public Category saveCategory(Category category) {
		Category rs = null;
		rs = categoryRepository.getCaterory(category.getName());
		if (rs == null) {
			return categoryRepository.save(category);
		}
		return null;
	}

	public Category updateCategory(Category category) {
		Category rs = null;
		rs = categoryRepository.getCaterory(category.getName());
		if (rs != null) {
			return categoryRepository.saveAndFlush(category);
		}
		return rs;
	}

	public Category deleteCategory(Category category) {
		Category rs = null;
		rs = categoryRepository.getCaterory(category.getName());
		if (rs != null) {
			categoryRepository.delete(rs);
			return rs;
		}
		return rs;
	}
}
