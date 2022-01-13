package com.project.sparktea.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table  (name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private String DOB;
	
	@Column
	private String profilepic;

	public User(String userRole, String email, String firstName, String lastName, String username, String password, String gender, String dOB) {
		super();
		this.userRole = userRole;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.gender = gender;
		DOB = dOB;
	}
	
	public User(int userid, String userRole, String email, String firstName, String lastName, String username, String password, String gender, String dOB) {
		super();
		this.userId = userid;
		this.userRole = userRole;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.gender = gender;
		DOB = dOB;
	}
	

	
//	@ToString.Exclude
//	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Post> post;
	
	
//	@ToString.Exclude
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonIgnore
//	private Logins logins;
	

	
	
	
//	@Column(name = "profilePicture")
//	private String profilePictureUrl;
//	
//	 public String getProfilePictureUrl() {
//		 return profilePictureUrl;
//	    }
//
//	 public void setProfilePictureUrl(String profilePictureUrl) {
//	     this.profilePictureUrl = profilePictureUrl;
//	    }
//	 
//	 @JsonIgnore
//	    private Set<User> following;
//	 
//	 @ManyToMany(cascade = CascadeType.ALL)
//	 @JoinTable(name = "following",
//	            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
//	            inverseJoinColumns = @JoinColumn(name = "followingId", referencedColumnName = "id"))
//	    public Set<User> getFollowing() {
//	        return following;
//	    }
//
//	@Column(name = "DOB")
//	private String DOB;
//		
}