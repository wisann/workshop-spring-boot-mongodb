package com.wisan.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wisan.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
