package com.project.sparktea.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.project.sparktea.dao.UserDaoHibernate;
import com.project.sparktea.model.User;
import com.project.sparktea.model.UserRepository;



import javax.annotation.Resource;


import com.project.sparktea.model.UserData;
import com.project.sparktea.service.UserService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
//@RequestMapping("/users")
public class UserController {
	
	//DANIEL
	@Resource(name="userService")
	private UserService userService;
	
	@GetMapping
	public List<UserData> getUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public UserData getUser(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/user")
	public UserData saveUser(final @RequestBody UserData userData) {
		return userService.saveUser(userData);
	}
	
	@DeleteMapping("/user/{id}") 
		public Boolean deleteUser(@PathVariable Integer id) {
			return userService.deleteUser(id);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		//JOSE
	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<User> users = new ArrayList<User>();
			
			if(title == null) 
				userRepository.findAll().forEach(users::add);
			 else 
				userRepository.findByTitleContaining(title).forEach(users::add);
			
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getTutorialById(@PathVariable("id") long id) {
		Optional<User> userData = userRepository.findById(id);
		
		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<User> createTutorial(@RequestBody User user) {
		try {
			User _user = userRepository
					.save(new User(user.getTitle(), user.getDescription(), false));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateTutorial(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setTitle(user.getTitle());
			_user.setDescription(user.getDescription());
			_user.setPublished(user.isPublished());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
		try {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/users")
	public ResponseEntity<HttpStatus> deleteAllUsers() {
		try {
			userRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/users/published")
	public ResponseEntity<List<User>> findByPublished() {
		try {
			List<User> users = userRepository.findByPublished(true);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}



