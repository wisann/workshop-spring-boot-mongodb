package com.wisan.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisan.workshopmongo.domain.User;
import com.wisan.workshopmongo.exception.ObjectNotFoundException;
import com.wisan.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	};
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Not found"));
	}

}
