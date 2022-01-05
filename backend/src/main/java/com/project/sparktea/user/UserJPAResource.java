package com.project.sparktea.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}

	@PostMapping("/users/register")
	public User createUser( @RequestBody User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
}
