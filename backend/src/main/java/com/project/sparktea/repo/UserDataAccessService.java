package com.project.sparktea.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sparktea.datastore.FakeUserProfileDataStore;
import com.project.sparktea.entity.User;

@Repository
public class UserDataAccessService {
	
	private final FakeUserProfileDataStore fakeUserProfileDataStore;
	
	@Autowired
	public UserDataAccessService(FakeUserProfileDataStore fakeUserProfileDataStore) {
		this.fakeUserProfileDataStore = fakeUserProfileDataStore;
	
	}
	
	List<User> getUserProfiles(){
		return fakeUserProfileDataStore.getUserProfiles();
	}
}
