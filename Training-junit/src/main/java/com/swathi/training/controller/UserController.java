package com.swathi.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swathi.training.entity.User;
import com.swathi.training.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
		@PostMapping("/api/users")
		public ResponseEntity<User> addUser(@RequestBody User user){
				
		User savedUser =userService.addUser(user);
			return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		}
		
		//getmapping
		@GetMapping("/api/users")
		public ResponseEntity<List<User>> viewUsers() {
			List<User> viewUsers = userService.viewUsers();
			return new ResponseEntity<>(viewUsers,HttpStatus.OK);
		}
		@GetMapping("/api/users/{id}")
		public ResponseEntity<User> viewUser(@PathVariable Integer id) {
			User getUser=userService.viewUser(id);
			return new ResponseEntity<>(getUser,HttpStatus.FOUND);
		}
		
		@GetMapping("/api/users/{address}")
		public ResponseEntity<List<User>> findUsersByAddress(@PathVariable String address) {
			List<User> getUsersByAddress=userService.findUsersByAddress(address);
			return new ResponseEntity<>(getUsersByAddress,HttpStatus.FOUND);
		}
		
		@DeleteMapping("/api/users/delete/{id}")
		public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
			userService.deleteUserById(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
		@PatchMapping("/api/users/edit")
		public ResponseEntity<User> editUser(@RequestBody User user){
			User saveUser = userService.saveUser(user);
			return new ResponseEntity<>(saveUser,HttpStatus.OK);
		}
		
	

}
