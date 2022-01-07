package com.project.sparktea.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.User;
import com.project.sparktea.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserJPAResource { //User controller
	
	@Autowired
	private UserRepository userRepository;
	
	UserService userS;
	
	@GetMapping
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/register")
	public User createUser( @RequestBody User user) {
		return userS.register(user);
	}
	
	@PostMapping("/login")
    public User userLogin(@RequestBody User user) {
       return userS.userLogin(user.getUsername(), user.getPassword());
    } 

	@GetMapping("/id/{id}")
	public User findByID(@PathVariable int id) {
		return userS.getUserByID(id);
	}
	
//	@GetMapping("/username/{username}")
//	public User findByUsername(@PathVariable String username) {
//		return new User();
//	}
//	
}
