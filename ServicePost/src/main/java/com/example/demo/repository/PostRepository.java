package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Post;

public interface PostRepository extends JpaRepository<Post, String> {
	@Query("SELECT p FROM Post p")
	public List<Post> getPostInRange(Pageable pageable);

	@Query("SELECT p FROM Post P WHERE p.status = ?1")
	public List<Post> getPostByStatusInRange(Pageable page, String status);
}
