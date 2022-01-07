package com.project.sparktea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.project.sparktea.entity.User;
import com.project.sparktea.repo.UserRepository;
import com.project.sparktea.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserJPAResource { //User controller
	
	@Autowired
	UserService userS;
	
	@Autowired
	UserRepository userR;
//	
	@GetMapping
	public List<User> retrieveAllUsers(){
		 return  userR.findAll();
	}
	
	@GetMapping("/addtest")
	public String makeUser() {
		User u = new User(4,"hi","hi","hi","hi","hi","hi","hi","hi");	
		userR.save(u);
		return "hello";
	}

	@PostMapping("/login")
    public User userLogin(@RequestBody User user) {
       return userS.userLogin(user.getUsername(), user.getPassword());
    } 
//	
	@PostMapping("/register")
	public User createUser( @RequestBody User user) {
		return userS.register(user);
	}
//	
	@GetMapping("/id/{id}")
	public User findByID(@PathVariable Integer id) {
		return userS.getUserByID(id);
	}
	
//	@GetMapping("/username/{username}")
//	public User findByUsername(@PathVariable String username) {
//		return new User();
//	}
//	
}
