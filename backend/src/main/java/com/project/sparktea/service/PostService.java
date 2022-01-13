package com.project.sparktea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sparktea.entity.Post;
import com.project.sparktea.entity.User;
import com.project.sparktea.repo.CommentRepository;
import com.project.sparktea.repo.PostRepository;
import com.project.sparktea.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

	@Autowired
    private CommentRepository commentRepo;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Post> getAllPosts(){
    	return postRepo.findAll();
    }
    
    public Optional<Post> getPostByID(Long id) {
        return postRepo.findById(id);
    }
     
	public Post createPost( Post post) {
		return postRepo.save(post);
	}
	
    public Post createPost(Post post, int userId) {
    	if(userRepo.findById(userId)==null) {
    		return null;
    	} else {
        return postRepo.save(post);
    	}
    }

    public void deleteById(Long id) {
    	 postRepo.deleteById(id);

    }
    
    public Post getPostByUsername(String username) {
		Post p = postRepo.findByUsername(username);
		System.out.println(p);
		return p;
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

}

