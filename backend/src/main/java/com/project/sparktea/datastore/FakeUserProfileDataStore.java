package com.project.sparktea.datastore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.sparktea.entity.User;

@Repository
public class FakeUserProfileDataStore {
	
	private static final List<User> USER_PROFILES = new ArrayList<>();
	
	static {
		USER_PROFILES.add(new User(1, "client", "johndoe@gmail.com", "John", "Doe", "johndoe", "password", null));
		USER_PROFILES.add(new User(2, "client", "janedoe@gmail.com", "Jane", "Doe", "janedoe", "password", null));

	}
	
	public List<User> getUserProfiles(){
		return USER_PROFILES;
	};
}
