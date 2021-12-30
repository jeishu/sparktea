package com.project.sparktea.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	  List<User> findByPublished(boolean published);

	  List<User> findByTitleContaining(String title);
	}
