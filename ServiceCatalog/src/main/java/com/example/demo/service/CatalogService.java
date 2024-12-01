package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Catalog;
import com.example.demo.repository.CatalogRepository;

@Service
public class CatalogService {
	@Autowired
	private CatalogRepository catalogRepository;

	public Catalog saveCatalog(Catalog catalog) {
		System.out.println("Catalog Server - Save Catalog");
		Catalog c = null;
		try {
			c = catalogRepository.save(catalog);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
		return c;
	}

	public Catalog updateCatalog(Catalog catalog) {
		System.out.println("Catalog Server - Save Catalog");
		Catalog c = null;
		try {
			c = catalogRepository.saveAndFlush(catalog);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
		return c;
	}

	public void deleteCatalog(Catalog catalog) {
		catalogRepository.delete(catalog);
	}

	public List<Catalog> getAllCatalog() {
		return catalogRepository.findAll();
	}

	public Catalog getCatalogByName(String name) {
		return catalogRepository.getCatalogByName(name);
	}

	public Catalog getCatalogByID(String id) {
		return catalogRepository.findById(id).orElseThrow();
	}

	public List<Catalog> getCatalogInRange(String type, int page, int size) {
		System.out.println("Catalog Service - Get Catalog By Status In Range");
		
		Pageable pageable = PageRequest.of(page - 1, size);
		switch (type) {
		case "all": {
			return catalogRepository.getCatalogInRange(pageable);
		}
		case "active": {
			return catalogRepository.getCatalogByStatusInRange(pageable, type);
		}
		case "inactive": {
			return catalogRepository.getCatalogByStatusInRange(pageable, type);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
		
	}

}
