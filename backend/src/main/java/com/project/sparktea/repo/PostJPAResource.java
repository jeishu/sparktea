package com.project.sparktea.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.Post;
import com.project.sparktea.service.PostService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController("/posts")
@CrossOrigin("*")
public class PostJPAResource {
	
	PostService postS;
	
	@GetMapping
	public List<Post> retrieveAllPosts(){
		return postS.getAllPosts();
	}

	@PostMapping("/create")
	public Post createPost( @RequestBody Post post) {		
		System.out.println(post);
		return postS.createPost(post);
	}
	
	@PostMapping("/create/userid/{id}")
	public Post createPost( @RequestBody Post post, @RequestParam int id)  {		
		System.out.println(post);
		return postS.createPost(post, id);
	}
	
	@DeleteMapping("/delete/id/{id}")
	public String deletePost( @RequestParam Long id) {	
		return postS.deletePost(id);
	}
}

