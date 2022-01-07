package com.project.sparktea.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sparktea.entity.Post;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin("*")
public class PostJPAResource {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
	public List<Post> retrieveAllPosts(){
		return postRepository.findAll();
	}

	@PostMapping("/posts/create")
	public Post createPost( @RequestBody Post post) {
		
		System.out.println(post);
		Post savedPost = postRepository.save(post);
		return savedPost;
	}
}
