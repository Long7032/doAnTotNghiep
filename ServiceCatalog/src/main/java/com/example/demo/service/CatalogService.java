package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
		return catalogRepository.save(catalog);
	}

	public Catalog updateCatalog(Catalog catalog) {
		return catalogRepository.saveAndFlush(catalog);
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

	public Optional<Catalog> getCatalogByID(String id) {
		return catalogRepository.findById(id);
	}

	public List<Catalog> getCatalogInRange(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return catalogRepository.getCatalogInRange(pageable);
	}

}
