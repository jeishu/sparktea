package com.project.sparktea.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sparktea.entity.Post;
import com.project.sparktea.entity.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	public Post findByUsername(String username);


	void deleteById(Long id);

}

