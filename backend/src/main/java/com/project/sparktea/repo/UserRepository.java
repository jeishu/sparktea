package com.project.sparktea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.sparktea.entity.User;

import org.springframework.data.repository.CrudRepository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);

//	public User findOne(Long userId);
	
	
}
		 
		 

		/*

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    public User findByUsername(String username);


}


*/