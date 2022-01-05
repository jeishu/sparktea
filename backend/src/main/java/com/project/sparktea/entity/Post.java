package com.project.sparktea.entity;


import javax.persistence.*;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity

@Table  (name = "posts", schema = "public")
public @Data class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
	
	@Column
    private String contnt;
	
	@Column(name = "dat")
    private String date;

	
	
	
//	@Column(name = "comments")
//    private Set<Comment> comments;

    
//
		@ManyToOne
      @JoinColumn(name = "userid")
	//	@JsonIgnore
    private User user;
//    public User getUser() {
//        return user;
//    }
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @OneToMany(mappedBy = "post")
//    public Set<Comment> getComments() {
//        return comments;
//    }
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }


}

