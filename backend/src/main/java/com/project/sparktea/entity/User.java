package com.project.sparktea.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

	//PREVIOUS CODE

@Entity
@Data
@Table  (name = "users", schema = "public")
public class User {

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

	@Column(name = "gender")
	private String gender;

	@Column(name = "DOB")
	private String DOB;
	
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
//	    public void setFollowing(Set<User> following) {
//	        this.following = following;
//	    }




//	public Object getTitle() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}






		/*


@Entity
public class User {

    private Long id;
    private String username;
    private String profilePictureUrl;

    @JsonIgnore
    private Set<User> following;

    private String password;

    @JsonIgnore
    private Set<Post> posts;

    @JsonIgnore
    private Set<Comment> comments;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user")
    public Set<Post> getPosts() {
        return posts;
    }
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(mappedBy = "user")
    public Set<Comment> getComments() {
        return comments;
    }
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "following",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "followingId", referencedColumnName = "id"))
    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }


}




*/