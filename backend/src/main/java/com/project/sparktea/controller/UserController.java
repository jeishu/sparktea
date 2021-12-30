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


	
	/* 
	 * //	private static final Logger logger = Logger.getLogger(UserController.class);

	static List<User> user;
	public static Handler getUsers = ctx -> {
		logger.info("Retrieves all user accounts");
		UserDaoHibernate userDaoHib = new UserDaoHibernate();
		ctx.json(userDaoHib.getAllUser());
	};

	public static Handler getSingleUser = ctx -> {
		logger.info("Retrieve a single user account");

		UserDaoHibernate userDaoHib = new UserDaoHibernate();
		User user = ctx.bodyAsClass(User.class);
		String username = user.getUsername();
		String password = user.getPassword();
		ctx.json(userDaoHib.getUserByUserNameAndPassword(username, password));
	};

	public static Handler userLogin = ctx -> {
		logger.info("Getting user information...");
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		UserDaoHibernate userDaoHib = new UserDaoHibernate();
		List<User> user = userDaoHib.getUserByUserNameAndPassword(username, password);
		User loggedUser = new User();
		for (User key : user) {
			logger.info("setting values for the logged in user...");

			loggedUser.setUserId(key.getUserId());
			loggedUser.setUserRole(key.getUserRole());
			loggedUser.setEmail(key.getEmail());
			loggedUser.setFirstName(key.getFirstName());
			loggedUser.setLastName(key.getLastName());
			loggedUser.setUserName(key.getUsername());
			loggedUser.setPassword(key.getPassword());
			loggedUser.setPassword(key.getGender());
			loggedUser.setPassword(key.getDOB());
			loggedUser.setPassword(key.getProfilePic());
		}

		if (userDaoHib.getUserByUserNameAndPassword(username, password) != null) {

			logger.info("Storing values");
		
			ctx.cookieStore("user", loggedUser);
			ctx.cookieStore("id", loggedUser.getUserId());
			ctx.cookieStore("userRole", loggedUser.getUserRole());
		}
	
	
		
		if (loggedUser.getUserRole().equals("enhanced")) {
			logger.info("Directing user to enhanced page");
			ctx.redirect("./managerpage.html");
		}
		if (loggedUser.getUserRole().equals("base")) {
			logger.info("Directing user to base page");
			ctx.redirect("./employeepage.html");
		}
		if (loggedUser.getUserRole().equals("admin")) {
			logger.info("Directing user to admin page");
			ctx.redirect("./employeepage.html");
		}
	};


	public static Handler userLogout = ctx -> {
		if (ctx.body().contains("log-out")) {
			logger.info("logging out...");
			ctx.clearCookieStore();
			ctx.result("Clearing user session..");
		} else {
			logger.warn("Error occurred while logging out");
			ctx.result("log out error occured");
		}

	};

	public static Handler updateUser = ctx -> {
		logger.info("Updating user information");
		UserDaoHibernate userDaoHib = new UserDaoHibernate();
		int id = ctx.cookieStore("id");
		String userRoleStored = ctx.cookieStore("userRole");
		String email = ctx.formParam("email");
		String firstname = ctx.formParam("firstname");
		String lastname = ctx.formParam("lastname");
		String password = ctx.formParam("password");
		String username = ctx.formParam("username");
		Integer DOB = ctx.formParam("DOB");
		Byte profilePic = tx.formParam("profile_pic");
		String userRole = userRoleStored;
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setPassword(password);
		user.setUserName(username);
		user.setUserId(id);
		user.setUserRole(userRole);
		user.setGender(gender);
		user.setDOB(DOB);
		user.setProfilePic(profilePic);
		userDaoHib.updateUser(user);
		
		
		//ctx.redirect("./employeepage.html");
	};

}
	 * 
	 * 
	 * 
	 * 
	 */

