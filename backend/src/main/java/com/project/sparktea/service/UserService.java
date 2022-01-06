package com.project.sparktea.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sparktea.entity.User;
import com.project.sparktea.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User createUser(User user) {
        return repo.save(user);
    }

    public User login(User user) throws Exception {
        User foundUser = repo.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())){
            return foundUser;
        } else {
            throw new Exception("Invalid username or password.");
        }
    }
    
    public void add(User user) {
    	System.out.println(user.getUsername());
    	String UserName = user.getUsername();
    	
    	User newUser = new User();
    	newUser.setUsername(user.getUsername());
    	newUser.setEmail(user.getEmail());
    	newUser.setPassword(user.getPassword());
    	newUser.setDOB(user.getDOB());
    	newUser.setFirstName(user.getFirstName());
    	newUser.setLastName(user.getLastName());
    	newUser.setGender(user.getGender());
    	newUser.setUserId(user.getUserId());
    	
    	repo.save(newUser);
    }

    
    
    
//    public Following follow(Long userId, Long followId) throws Exception {
//        User user = repo.findOne(userId);
//        User follow = repo.findOne(followId);
//        if (user == null || follow == null) {
//            throw new Exception("User does not exist.");
//        }
//        user.getFollowing().add(follow);
//        repo.save(user);
//        return new Following(user);
//    }

//    public Following getFollowedUsers(Long userId) throws Exception {
//        User user = repo.findOne(userId);
//        if (user == null) {
//            throw new Exception("User does not exist. ");
//        }
//        return new Following(user);
//    }

//    public User updateProfilePicture(Long userId, String url) throws Exception {
//        User user = repo.findOne(userId);
//        if (user == null) {
//            throw new Exception("User does not exist.");
//        }
//        user.setProfilePictureUrl(url);
//        return repo.save(user);
//    }

}

