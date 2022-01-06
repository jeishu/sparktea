package com.project.sparktea.entity;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table  (name = "users", schema = "public")
public @Data  class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int userId;

	@Column(name = "userole")
	private String userRole;

	@Column(name = "email")
	private String email;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "username")
	private String username;

	@Column(name = "passwrd")
	private String password;

//	@Column(name = "gender")
//	private String gender;
//
//	@Column(name = "DOB")
//	private String DOB;
//	
	@Column(name = "profileimglink")
	private String profileImgLink; // S3 key/link
	
	public Optional<String> getProfileImgLink() {
		return Optional.ofNullable(profileImgLink);
	}
	
	public void setProfileImgLink(String profileImgLink) {
		this.profileImgLink = profileImgLink;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(profileImgLink, userId, username);
	}

	//Object everything maybe?
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		return Objects.equals(profileImgLink, other.profileImgLink) && 
			   Objects.equals(userId, other.userId)&& 
			   Objects.equals(username, other.username);
	}

	public User(int i, String string, String string2, String string3, String string4, String string5, String string6,
			Object object) {
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	

	
}