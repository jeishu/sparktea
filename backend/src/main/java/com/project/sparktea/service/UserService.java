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
    
    public List<User> getAllUsers(){
		return repo.findAll();
	}

    public User userLogin(String username, String password) {
        User loggedInUser = repo.findByUsername(username);    
        if(loggedInUser.getPassword().equals(password)) {
            return loggedInUser;
        }else {
            return null;
        }
    } 
    
    public User register(User user) {
		return repo.save(user);
    }
    
    public User getUserByID(Integer id) {
		User u = repo.getById(id);
		System.out.println(u);
		return u;
    }
    
    public User getUserByUsername(String username) {
		User u = repo.findByUsername(username);
		System.out.println(u);
		return u;
    }


	public String updateUser(User user) {
		User u = repo.findByUsername(user.getUsername());
		//u.setUsername(user.getUsername());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		u.setDOB(user.getDOB());
		u.setGender(user.getGender());
		repo.save(u); //needed for updates
		return u.toString();
	}

	public String updateProfilePic(User user) {
		User u = repo.findByUsername(user.getUsername());
		u.setProfilepic(user.getProfilepic());
		repo.save(u);
		return null;
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

