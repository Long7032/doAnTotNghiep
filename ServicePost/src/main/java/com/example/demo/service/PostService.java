package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public Post savePost(Post post) {
		System.out.println("Post Service - Save Post");
		if (post.getTimeCreate() != null) {
			post.setTimeCreate(LocalDateTime.now());
		}
		Post p = null;

		try {

			p = postRepository.save(post);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}

		return p;
	}

	public Post updatePost(Post post) {
		System.out.println("Post Service - Update Post");
		Post p = null;

		try {

			p = postRepository.saveAndFlush(post);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}

		return p;
	}

	public List<Post> getPosts() {
		System.out.println("Post Service - Get All Post");
		return postRepository.findAll();
	}

	public void resetService() {
		System.out.println("Post Service - Delete All Data In Service");
		postRepository.deleteAll();
	}

	public List<Post> getCatalogInRange(String type, int page, int size) {
		System.out.println("Catalog Service - Get Catalog By Status In Range");

		Pageable pageable = PageRequest.of(page - 1, size);
		switch (type) {
		case "all": {
			return postRepository.getPostInRange(pageable);
		}
		case "active": {
//			return postRepository.getPostByStatusInRange(pageable, type);
		}
		case "inactive": {
//			return postRepository.getPostByStatusInRange(pageable, type);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

	}

}
