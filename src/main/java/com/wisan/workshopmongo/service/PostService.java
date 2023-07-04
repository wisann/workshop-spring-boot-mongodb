package com.wisan.workshopmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisan.workshopmongo.domain.Post;
import com.wisan.workshopmongo.exception.ObjectNotFoundException;
import com.wisan.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Not found"));
	}

}
