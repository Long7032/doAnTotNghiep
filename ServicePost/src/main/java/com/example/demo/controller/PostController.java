package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> getPostsByID(@PathVariable String id) {
		System.out.println("Post Controller - Get Post By ID");
		try {
			Object post = postService.getPostByID(id);
			return ResponseEntity.status(200).body(post);
		} catch (Exception e) {
			System.err.println("An error occurred while fetching post by ID: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(500).body("An error occurred while fetching post by ID.");
		}
	}

	@GetMapping("/{type}/{page}/{size}")
	public ResponseEntity<Object> getPostsInRange(@PathVariable String type, @PathVariable int page,
			@PathVariable int size) {
		System.out.println("Post Controller - Get Posts In Range");
		try {
			List<Post> posts = postService.getPostsInRange(type, page, size);
			return ResponseEntity.status(200).body(posts);
		} catch (Exception e) {
			System.err.println("An error occurred while fetching posts in range: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(500).body("An error occurred while fetching posts in range.");
		}
	}

	
	@PostMapping("/")
	public ResponseEntity<Object> savePost(@RequestBody Post post) {
	    System.out.println("Post Controler - Save Post");
	    
	    try {
	        return ResponseEntity.status(200).body(postService.savePost(post));
	    } catch (Exception e) {
	        System.err.println("Error occurred while saving post: " + e.getMessage());
	        return ResponseEntity.status(500).body("An error occurred while saving the post");
	    }
	}


	
}
