//package com.project.sparktea.user;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//@Entity
//@Table  (name = "users", schema = "public")
//public @Data  class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "userid")
//	private int userId;
//
//	@Column(name = "userole")
//	private String userRole;
//
//	@Column(name = "email")
//	private String email;
//
//	@Column(name = "firstname")
//	private String firstName;
//
//	@Column(name = "lastname")
//	private String lastName;
//
//	@Column(name = "username")
//	private String username;
//
//	@Column(name = "password")
//	private String password;
//
//	@Column(name = "gender")
//	private String gender;
//
//	@Column(name = "DOB")
//	private String DOB;
//
//
//}