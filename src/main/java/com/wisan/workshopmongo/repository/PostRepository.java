package com.wisan.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wisan.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
