package com.basic.UsserOpration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.UsserOpration.model.User;
import com.basic.UsserOpration.repo.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	//Saving data
	
	@PostMapping("/userSave")
	public String insertUser(@RequestBody User user) {
		
	userRepository.save(user);
	
		return "User saved Sucessfully..";
	}
	
	@PostMapping("/multipleUserSave")
	public String insertUser(@RequestBody List<User> user) {
		
	userRepository.saveAll(user);
	
		return "Multiple User's saved Sucessfully..";
	}
	
	
	//feching data
	
	@GetMapping("/getAllUser")
	public List<User> getUser() {
		
		return (List<User>)userRepository.findAll();
	}
	
	@GetMapping("/getByUserName/{userName}")
	public List<User> getUser(@PathVariable("userName") String userName) {
		
		return (List<User>)userRepository.findByUserName(userName);
	}
	
	
	@GetMapping("/getByUserId/{userId}")
	public Optional<User> getUser(@PathVariable("userId") long id) {
		
		return userRepository.findById(id);
	}

	//update
	@PutMapping("/updateByUserId/{UserId}")
	//public Optional<User> updateUser(@PathVariable("userId") long id,@RequestBody User userDatails) {
	public User updateUser(@PathVariable("userId") long id,@RequestBody User userDatails) {	
	User updateUser= userRepository.findById(id).orElseThrow();
	
			updateUser.setUserName(userDatails.getUserName());
			updateUser.setEmail(userDatails.getEmail());
			updateUser.setMobileNumber(userDatails.getMobileNumber());
			updateUser.setUserAddress(userDatails.getUserAddress());
			userRepository.save(updateUser);
			//return userRepository.findById(id);
			return updateUser;
	}
	
	//Deleting Data	
	
	
/*
	@DeleteMapping("/deleteByUserName/{userName}")
	public String deleteUser(@PathVariable("userName") String userName) {
		
		userRepository.deleteByUserName(userName);
		 return "user Delete Sucessfully";
	}
	*/
	
	@DeleteMapping("/deleteByUserId/{userId}")
	public String deleteUser(@PathVariable("userId") long id) {
		
		 userRepository.deleteById(id);
		 
		 return "user Delete Sucessfully";
	}
}
