package com.project.sparktea.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.User;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
@RequestMapping("/users")
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}

	@PostMapping("/register")
	public User createUser( @RequestBody User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	@GetMapping("/username/{username}")
	public User findByUsername(@PathVariable String username) {
		return new User();
	}
	
	@GetMapping("/id/{id}")
	public Optional<User> findByID(@PathVariable int id) {
		return userRepository.findById(id);
	}
}
