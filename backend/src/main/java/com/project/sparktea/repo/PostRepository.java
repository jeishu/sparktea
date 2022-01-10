package com.project.sparktea.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sparktea.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}

