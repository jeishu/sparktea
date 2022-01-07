package com.project.sparktea.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.Comment;
import com.project.sparktea.service.CommentService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController("comments")
@CrossOrigin("*")
public class CommentJPAResource {
	
	CommentService comS;

	@GetMapping
	public List<Comment> retrieveAllComment(){
		return comS.getAllComments();
	}

	@PostMapping("/create")
	public Comment createComment( @RequestBody Comment comment) {
		return comS.createComment(comment);
	}

@DeleteMapping("/delete/id/{id}")
public String createComment( @RequestParam Long id) {	
	return comS.deleteComment(id);
}
}

