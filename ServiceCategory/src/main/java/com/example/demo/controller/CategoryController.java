package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public List<Category> getCaregories() {
		return categoryService.getCategories();
	}

	@GetMapping("/{name}")
	public Category getCategory(@PathVariable String name) {
		return categoryService.getCategory(name);
	}

	@PostMapping("/")
	public Category saveCategory(@RequestBody Category category) {
		// TODO: process POST request

		return categoryService.saveCategory(category);
	}

	@PutMapping("/{name}")
	public String updateCategory(@PathVariable String name, @RequestBody Category category) {
		if (categoryService.updateCategory(name, category.getName())) {
			return "update category success";
		}
		return "update category fail";
	}

	@DeleteMapping("/{name}")
	public String deleteCategory(@PathVariable String name) {
		if (categoryService.deleteCategory(name)) {
			return "delete category success";
		}		;
		return "delete category fail";
	}
}
