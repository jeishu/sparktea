package com.project.sparktea.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sparktea.entity.Post;
import com.project.sparktea.entity.User;
import com.project.sparktea.repo.PostRepository;
import com.project.sparktea.repo.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    @Autowired
    private UserRepository userRepo;

    public Iterable<Post> getAllPosts() {
        return repo.findAll();
    }

    public Post getPost(Long id) {
       return new Post();
    }
    
    public List<Post> getAllPost(){
    	return repo.findAll();
    }
//    public Post updatePost(Post post, Long id) throws Exception {
//        Post foundPost = repo.findOne(id);
//        if (foundPost == null) {
//            throw new Exception("Post not found.");
//        }
//        foundPost.setContent(post.getContent());
//        return repo.save(foundPost);
//    }
//
//    public Post createPost(Post post, Long userId) throws Exception {
//        User user = userRepo.findOne(userId);
//        if (user == null) {
//            throw new Exception("User not found. ");
//        }
//        post.setDate(new Date());
//        post.setUser(user);
//        return repo.save(post);
//    }
}

