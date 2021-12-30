package com.project.sparktea.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {
	
	private int userId;
	private String userRole;
	private String email;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String gender;
	private int DOB;
	private byte profilePic;
	
	public UserData() {
		
	}
	
	
	

}
