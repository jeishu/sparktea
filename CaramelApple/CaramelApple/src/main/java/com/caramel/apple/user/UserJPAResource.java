package com.caramel.apple.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:3000") 
public class UserJPAResource {
  
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<Users> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/users/register")
	public Users createUser(@RequestBody Users user) {
		Users savedUser = userRepository.save(user);
		return savedUser;
		
	}
	
	@PostMapping("/users/login")
	public HttpStatus userLogin(@RequestBody Users user) {
		HttpStatus statush = null;
		String usernameJs =user.getUsername();
		String passwordJs=user.getPassword();
		List<Users> loggedInUser = userRepository.findByUsername(usernameJs);
		for(Users usr: loggedInUser) {
				if(usr.getPassword().equals(passwordJs)) {
			statush= HttpStatus.OK;
		}else {
			statush= HttpStatus.BAD_REQUEST;}
		}
	return statush;
	
}
}