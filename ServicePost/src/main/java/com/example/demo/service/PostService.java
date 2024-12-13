package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

		if (post.getTimeCreate() == null) {
			post.setTimeCreate(LocalDateTime.now());
		}

		try {
			Post savedPost = postRepository.save(post);
			System.out.println("Post saved successfully: " + savedPost);
			return savedPost;
		} catch (Exception e) {
			System.err.println("An error occurred while saving the post: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Post updatePost(Post post) {
		System.out.println("Post Service - Update Post");

		try {
			Post updatedPost = postRepository.saveAndFlush(post);
			System.out.println("Post updated successfully: " + updatedPost);
			return updatedPost;
		} catch (Exception e) {
			System.err.println("An error occurred while updating the post: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public List<Post> getPosts() {
		System.out.println("Post Service - Get All Post");
		try {
			return postRepository.findAll();
		} catch (Exception e) {
			System.err.println("An error occurred while fetching all posts: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public void resetService() {
		System.out.println("Post Service - Delete All Data In Service");
		try {
			postRepository.deleteAll();
		} catch (Exception e) {
			System.err.println("An error occurred while deleting all data: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Post> getPostsInRange(String type, int page, int size) {
		System.out.println("Post Service - Get Post By Status In Range");
		Pageable pageable = PageRequest.of(page - 1, size);

		try {
			switch (type) {
			case "all": {
				return postRepository.getPostInRange(pageable);
			}
			case "active": {
//				return postRepository.getPostByStatusInRange(pageable, type);
			}
			case "inactive": {
//				return postRepository.getPostByStatusInRange(pageable, type);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while fetching posts in range: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public Post getPostByID(String id) {
		System.out.println("Post Service - Get Post By ID");

		try {
			return postRepository.findById(id).orElseThrow();
		} catch (Exception e) {
			System.err.println("An error occurred while fetching post by ID: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
