package com.swathi.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swathi.training.entity.User;
import com.swathi.training.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	public List<User> viewUsers() {
		
		List<User> users = userRepository.findAll();
		System.out.println("Getting data from DB: "+ users);
		return users;
	}

	public User viewUser(Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		
		return user.get();
	}

	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
		
	}

	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	public List<User> findUsersByAddress(String address) {

		return userRepository.findByAddress(address);
	}
	

}
