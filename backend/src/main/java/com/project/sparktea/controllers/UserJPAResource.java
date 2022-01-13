package com.project.sparktea.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.User;
import com.project.sparktea.repo.UserRepository;
import com.project.sparktea.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserJPAResource { //User controller
	
	static Logger logger = LoggerFactory.getLogger(UserJPAResource.class);

	@Autowired
	UserService userS;
	
	@Autowired
	UserRepository userR;
	
	@GetMapping
	public List<User> retrieveAllUsers(){
		logger.trace("Current Users");
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
		logger.info(user.getUsername());
		return userS.userLogin(user.getUsername(), user.getPassword());
    } 
	
	@PostMapping("/register")
	public User createUser( @RequestBody User user) {
//		logger.info(userS.register(user));
		return userS.register(user);
	}
	
	@GetMapping("/id/{id}")
	public User findByID(@PathVariable Integer id) {
		return userS.getUserByID(id);
	}
	
	@GetMapping("/username/{username}")
	public User getUserbyUsername(@PathVariable String username) {
		return userS.getUserByUsername(username);
	}
	
	@PutMapping("/update/")
	public String updateUserInfo(@RequestBody User user) {
		return userS.updateUser(user);
	}
	
//	@PutMapping("/update/profilepic")
//	public String updateProfilePic(@RequestBody User user) {
//		return userS.updateProfilePic(user);
//	}
	
	@PostMapping("/photoloc/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        Optional<User> userData = userR.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setProfilepic(user.getProfilepic());
            return new ResponseEntity<>(userR.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
	
}
