package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Catalog;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/catalogs")
public class CatalogController {
	@Autowired
	private CatalogService catalogService;

	@PostMapping("/")
	public Catalog saveCatalog(@RequestBody Catalog catalog) {
		return catalogService.saveCatalog(catalog);
	}

	@GetMapping("/")
	public ResponseEntity<Object> getCatalogs() {
		return ResponseEntity.status(200).body(catalogService.getAllCatalog());
	}

	@GetMapping("/number")
	public ResponseEntity<Object> getNumberOfCatalog() {
		return ResponseEntity.status(200).body(catalogService.getAllCatalog().toArray().length);
	}

	@PostMapping("/id")
	public ResponseEntity<Object> getCatalogById(@RequestBody Catalog catalog) {
		// TODO: process POST request
		System.out.println("Catalog Controller - Get Catalog By ID");
		Optional<Catalog> rs = catalogService.getCatalogByID(catalog.getId());
		return ResponseEntity.status(200).body(rs);
	}

	@PostMapping("/name")
	public ResponseEntity<Object> getCatalogByName(@RequestBody Catalog catalog) {
		// TODO: process POST request
		System.out.println("Catalog Controller - Get Catalog By Name");
		Catalog rs = catalogService.getCatalogByName(catalog.getName());
		return ResponseEntity.status(200).body(rs);
	}
	
	@GetMapping("/{page}/{size}")
	public ResponseEntity<Object> getCatalogInRange(@PathVariable int page, @PathVariable int size) {
		System.out.println("Catalog Controller - Get Catalog In Range");
		List<Catalog> rs = catalogService.getCatalogInRange(page, size);
		return ResponseEntity.status(200).body(rs);
	}
	
	@PutMapping("/")
	public  ResponseEntity<Object>  updateCatalog(@RequestBody Catalog catalog) {
		//TODO: process PUT request
		System.out.println("Catalog Controller - Update Catalog");
		Catalog rs = catalogService.updateCatalog(catalog);
		return ResponseEntity.status(200).body(rs);
	}
	
}
