package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
	@Query("SELECT c FROM Catalog c where c.name = ?1")
	public Catalog getCatalogByName(String name);

	@Query("SELECT c FROM Catalog c")
	public List<Catalog> getCatalogInRange(Pageable page);

	@Query("SELECT c FROM Catalog c WHERE c.status = ?1")
	public List<Catalog> getCatalogByStatusInRange(Pageable page, String status);
}
