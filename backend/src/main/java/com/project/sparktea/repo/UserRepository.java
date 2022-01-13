package com.project.sparktea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.sparktea.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);

}
		 