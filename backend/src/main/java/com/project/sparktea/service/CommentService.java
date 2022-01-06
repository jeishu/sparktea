package com.project.sparktea.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sparktea.entity.Comment;
import com.project.sparktea.entity.Post;
import com.project.sparktea.entity.User;
import com.project.sparktea.repo.CommentRepository;
import com.project.sparktea.repo.PostRepository;
import com.project.sparktea.repo.UserRepository;

import java.util.Date;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repo;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    public Comment createComment(Comment comment, Long userId, Long postId) throws Exception {
        User user = new User();
        Post post = new Post();
        if (user == null || post == null ) {
            throw new Exception("User or Post does not exist.");
        }
        //comment.setDate(new Date());
        comment.setUser(user);
        comment.setPost(post);
        return repo.save(comment);
    }

//    public void deleteComment(Long commentId) {
  //      repo.delete(commentId);
    //}

}

