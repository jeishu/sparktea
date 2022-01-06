package com.project.sparktea.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sparktea.entity.User;

@Service
public class UserProfileService {
	
	private final UserDataAccessService userDataAccessService;
	
	@Autowired
	public UserProfileService(UserDataAccessService userDataAccessService) {
		this.userDataAccessService = userDataAccessService;
	}
	
	List<User> getUserProfiles(){
		return userDataAccessService.getUserProfiles();
	}
}
