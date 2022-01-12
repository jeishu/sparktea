package com.project.sparktea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.Post;
import com.project.sparktea.entity.User;
import com.project.sparktea.service.PostService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostJPAResource {
	
	@Autowired
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
	
<<<<<<< HEAD
	@DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {
         postS.deleteById(id);
    }

=======
	@DeleteMapping("/delete/id/{id}")
	public String deletePost( @RequestParam Long id) {	
		return postS.deletePost(id);
	}
	
	@GetMapping("/username/{username}")
	public Post getPostbyUsername(@PathVariable String username) {
		return postS.getPostByUsername(username);
	}
>>>>>>> 73a94cd6592f8193e34b5ee54de87a6eb7e7b124
}

