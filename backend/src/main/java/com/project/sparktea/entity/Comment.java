package com.project.sparktea.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.Date;


@Entity
@Data
@Table  (name = "commnts", schema = "public")
public class Comment {
	
	@Id
    @GeneratedValue
	@Column(name = "id")
    private Long id;
	
	@Column
    private String contnt;
	
	@Column(name = "dat")
    private String date;


//

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "postid")
//    private Post post;
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }


}