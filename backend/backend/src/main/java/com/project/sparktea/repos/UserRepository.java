package com.project.sparktea.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sparktea.model.User;

	@Repository
	public interface UserRepository extends JpaRepository<User, Integer> {
		
		
	}
