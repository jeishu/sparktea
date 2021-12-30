package com.project.sparktea.controller;

import java.util.List;
import java.util.logging.Handler;

import com.project.sparktea.dao.UserDaoHibernate;
import com.project.sparktea.model.User;


public class UserController {

//	private static final Logger logger = Logger.getLogger(UserController.class);

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
	
	
	/*	
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
*/

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
