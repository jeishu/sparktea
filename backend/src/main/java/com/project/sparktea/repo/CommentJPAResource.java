package com.project.sparktea.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.Comment;
import com.project.sparktea.repo.CommentRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins="*")
public class CommentJPAResource {

	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping("/comments")
	public List<Comment> retrieveAllComment(){
		return commentRepository.findAll();
	}

	@PostMapping("/comments/create")
	public Comment createComment( @RequestBody Comment comment) {
		Comment savedComment = commentRepository.save(comment);
		return savedComment;
	}
}

