package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> getCaregories() {
		System.out.println("Category Controller - Get All Categories");
		List<Category> rs = categoryService.getCategories();
		return ResponseEntity.status(200).body(rs);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCategoryByCategoryID(@PathVariable String id) {
		System.out.println("Category Controller - Get Category By Category ID");
		try {
			Category rs = categoryService.getCategoryByCategoryID(id);
			return ResponseEntity.status(200).body(rs);
		} catch (NoSuchElementException e) {
			System.err.println("Category not found: " + e.getMessage());
			return ResponseEntity.status(404).body("Category not found");
		} catch (Exception e) {
			System.err.println("An error occurred while getting the category by ID: " + e.getMessage());
			return ResponseEntity.status(500).body("An internal server error occurred. Please try again later.");
		}
	}

	@PostMapping("/data-sample")
	public ResponseEntity<Object> saveDataSample(@RequestBody List<Category> category) {
		System.out.println("Category Controller - Get Category By ID");
		category.forEach(e -> {
			categoryService.saveCategory(e);
		});
		return ResponseEntity.status(200).body(new String("OK"));
	}

//	@PostMapping("/id")
//	public ResponseEntity<Object> getCaregoryByID(@RequestBody Category category) {
//		System.out.println("Category Controller - Get Category By ID");
//		return ResponseEntity.status(200).body(categoryService.getCategoryByID(category.getId()));
//	}

	@GetMapping("/{page}/{size}")
	public ResponseEntity<Object> getCaregoriesByPage(@PathVariable int page, @PathVariable int size) {
		System.out.println("Category Controller - Get Categories By Page");
		List<Category> rs = categoryService.getCategoriesInRange(page, size);
		if (rs.toArray().length == 0) {
			return ResponseEntity.status(409).body(categoryService.getCategoriesInRange(page, size));
		}
		return ResponseEntity.status(200).body(categoryService.getCategoriesInRange(page, size));
	}

	@GetMapping("/active/{page}/{size}")
	public ResponseEntity<Object> getCaregoriesByPageActive(@PathVariable int page, @PathVariable int size) {
		System.out.println("Category Controller - Get Category Active By Page");
		List<Category> rs = categoryService.getCategoriesInRangeActive(page, size);
		if (rs.toArray().length == 0) {
			return ResponseEntity.status(409).body(categoryService.getCategoriesInRangeActive(page, size));
		}
		return ResponseEntity.status(200).body(categoryService.getCategoriesInRangeActive(page, size));
	}

	@GetMapping("/name")
	public ResponseEntity<Object> getCategory(@RequestBody Category category) {
		Category rs = categoryService.getCategory(category.getName());
		if (rs != null) {
			return ResponseEntity.status(200).body(rs);
		}
		return ResponseEntity.status(409).body(new String("Fail"));
	}

	@PostMapping("/")
	public ResponseEntity<Object> saveCategory(@RequestBody Category category) {
		// TODO: process POST request
//		System.out.println("Service Product - Controller - saveCategory - Data: " + category.getName());
		Category rs = categoryService.saveCategory(category);
		if (rs != null) {
			return ResponseEntity.status(200).body(new String("Success"));
		}
		return ResponseEntity.status(409).body(new String("Fail"));
	}

	@PutMapping("/")
	public ResponseEntity<Object> updateCategory(@RequestBody Category category) {
		Category rs = categoryService.updateCategory(category);
		if (rs != null) {
			return ResponseEntity.status(200).body(new String("Success"));
		}
		return ResponseEntity.status(409).body(new String("Fail"));
	}

	@DeleteMapping("/")
	public ResponseEntity<Object> deleteCategory(@RequestBody Category category) {
		System.out.println("Service Product - Controller - Data: " + category.getName());
		if (categoryService.deleteCategory(category) != null) {
			return ResponseEntity.status(200).body(new String("Success"));
		}
		;
		return ResponseEntity.status(409).body(new String("Fail"));
	}
}
