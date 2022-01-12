package com.project.sparktea.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table  (name = "posts", schema = "public")
public class Post {

	@Id
    @GeneratedValue
	@Column(name = "id")
    private Long id;
	
	@Column
    private String contnt;
	
	@Column(name = "dat")
    private String date;
	
	@Column(name = "username")
	private String username;

	@Column(name="userid")
	private int userid;
//
//	
//	@ToString.Exclude
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JsonIgnore
//	private User user;

	

	
//	@Column(name = "comments")
//    private Set<Comment> comments;

    
//
//    public User getUser() {
//        return user;
//    }
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @OneToMany(mappedBy = "users")
//    public Set<User> getUsers() {
//       
//    }
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }


}

