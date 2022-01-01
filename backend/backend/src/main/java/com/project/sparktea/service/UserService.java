package com.project.sparktea.service;

import java.util.List;

import com.project.sparktea.model.UserData;

public interface UserService extends Jpa{
	
	UserData saveUser(UserData user);
	boolean deleteUser(final Integer userId);
	List<UserData> getAllUsers();
	UserData getUserById(final Integer userId);

}
