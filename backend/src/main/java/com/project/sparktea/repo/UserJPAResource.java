package com.project.sparktea.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

//This is a controller
@RestController
@CrossOrigin("*")
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	static public User user;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/users/register")
	public User createUser( @RequestBody User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
//	@PostMapping("/users/login")
//	public HttpStatus userLogin(@RequestBody User user) {
//		HttpStatus statush = null;
//		String usernameJs =user.getUsername();
//		String passwordJs=user.getPassword();
//		User loggedInUser = userRepository.findByUsername(usernameJs);
//		
//		if(loggedInUser.getPassword().equals(passwordJs)) {
//			statush= HttpStatus.OK;
//		}else {
//			statush= HttpStatus.BAD_REQUEST;
//		}
//		return statush;
//	}
	
	@PostMapping("/users/login")
	public User userLogin(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		User loggedInUser = userRepository.findByUsername(username);
		
		if(loggedInUser.getPassword().equals(password)) {
			return user;
		}else {
			return null;
		}
	}
	
//	@GetMapping("/username/{username}")
//	public User findByUsername(@PathVariable String username) {
//		return new User();
//	}
//	
//	@GetMapping("/id/{id}")
//	public Optional<User> findByID(@PathVariable int id) {
//		return userRepository.findById(id);
//	}
	
}
