package com.project.sparktea.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.Date;


@Entity

@Table  (name = "commnts", schema = "public")
public @Data class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "contnt")
    private String content;
	
	@Column(name = "dat")
    private Date date;


//
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }


}


		/*
		 * 
		 * 
@Entity
public class Comment {

    private Long id;
    private String content;
    private Date date;
    private User user;


    @JsonIgnore
    private Post post;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "postId")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


}
		 * 
		 * 
		 * 
		 */


/*
 * http://localhost:7070/users
 * 
 * http://localhost:7070/users
 * 
 * export default function Home(){

    const loginsAPI = ("http://localhost:8081/logins/");    
    const [email, setEmail] = useState('');
    const [pswd, setPswd] = useState('');

    useEffect(function effectFunction() {
        axios.get(loginsAPI+"whoisloggedin")
            .then(response => response) 
            .then(({data}) => {
                currentUser(data)
            .catch(err => {
                console.log("Error occured", err);
            })
            });
    }, []);

    function submit(){
 //   @PostMapping("users/login/{username}/{passwrd}")
        axios.post(loginsAPI+"login/"+email+"/"+pswd,{ })
            .then(response => response)
            .then(({data}) => {
                submitted(data)
            .catch(err => {
                console.log("Error occured", err);
            })
            });
    
    }

 * function currentUser(data){
    console.log(data.firstName);
    if(data.firstName === undefined){ //if no one is logged in
        document.getElementById("thisUser").innerHTML = "";
    }else{
        document.getElementById("thisUser").innerHTML = data.firstName+ " is logged in!";
    }
}

function submitted(data){
    console.log(data.firstName);
    if(data.firstName === undefined){
        document.getElementById("thisUser").innerHTML = "login credentials are invalid. Please try again";
    }else{
        
        userIsLoggedIn();

       // document.getElementById("thisUser").innerHTML = data.firstName+ " is already logged in!";
    }
}

 * 
 * 
 */

