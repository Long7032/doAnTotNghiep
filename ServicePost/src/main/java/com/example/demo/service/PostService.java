package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public Post savePost(Post post) {
		if(post.getTimeCreate() != null) {
			post.setTimeCreate(LocalDateTime.now());
		}
		return postRepository.save(post);
	}
	
	public Post updatePost(Post post) {
		return postRepository.saveAndFlush(post);
	}
	
	public List<Post> getPosts(){
		return postRepository.findAll();
	}
}
