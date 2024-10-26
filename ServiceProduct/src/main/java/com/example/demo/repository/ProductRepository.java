package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	@Query("select p from Product p where p.barcode = ?1")
	public Product getProductByBarcode(String barcode);

	@Query("SELECT p FROM Product p")
	public List<Product> getProductInRange(Pageable pageable);
	
	@Query("select p from Product p where p.name LIKE %:name%")
	public List<Product> getProductByName(@Param("name") String name);
	
	@Query("select p from Product p where p.idCategory = ?1")
	public List<Product> getProductByCategory(int id);
}
