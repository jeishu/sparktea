package com.project.sparktea.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sparktea.model.User;
import com.project.sparktea.model.UserData;
import com.project.sparktea.repos.UserRepository;


@Service("userService")
public class DefaultUserService implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserData saveUser(UserData user) {	
		User userModel = populateUserEntity(user);
		return populateUserData(userRepository.save(userModel));
	}
		
		public boolean deleteUser (Integer userID) {
			userRepository.deleteById(userID);
			return true;
		}
		
		public List <UserData> getAllUsers() {
			List <UserData> users = new ArrayList<> ();
			List <User> userList = userRepository.findAll();
			userList.forEach(user -> {
				users.add(populateUserData(user));
			});
			
			return users;
	}
		
		public UserData getUserById(Integer userId) {
		return populateUserData(userRepository.findById(userId).orElseThrow(() ->
		new EntityNotFoundException("User not found")));
		}

		private UserData populateUserData(final User user) {
			UserData userData =new UserData();
			
			userData.setUserId(user.getUserId());
			userData.setUserRole(user.getUserRole());
			userData.setEmail(user.getEmail());
			userData.setFirstName(user.getFirstName());
			userData.setLastName(user.getLastName());
			userData.setUsername(user.getUsername());
			userData.setPassword(user.getPassword());
			userData.setGender(user.getGender());
			userData.setDOB(user.getDOB());
			userData.setProfilePic(user.getProfilePic());
			return userData;
		}
		
		private User populateUserEntity(UserData userData) {
			User user = new User();
			user.setUserRole(userData.getUserRole());
			user.setFirstName(userData.getFirstName());
			user.setLastName(userData.getLastName());
			user.setGender(userData.getGender());
			user.setDOB(userData.getDOB());
			return user;
			
		}
}
