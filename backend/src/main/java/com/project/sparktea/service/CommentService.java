package com.project.sparktea.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.sparktea.entity.Comment;
import com.project.sparktea.entity.Post;
import com.project.sparktea.entity.User;
import com.project.sparktea.repo.CommentRepository;
import com.project.sparktea.repo.PostRepository;
import com.project.sparktea.repo.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;
    
    public List<Comment> getAllComments(){
		return commentRepo.findAll();
	}
    
	public Comment createComment( Comment comment) {
		return commentRepo.save(comment);
	}

    public String deleteComment(Long commentId) {
       commentRepo.deleteById(commentId);
       if(getCommentByID(commentId)==null) {
    	   return "success";
       }else {
    	   return "unable to perform request";
       }
    }
    
	public Optional<Comment> getCommentByID( Long id) {
		return commentRepo.findById(id);
	}

}

