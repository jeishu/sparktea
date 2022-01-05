package com.project.sparktea.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.sparktea.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	//void delete(Long commentId);

}

