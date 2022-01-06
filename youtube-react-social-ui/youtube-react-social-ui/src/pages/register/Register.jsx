import "./register.css";



import { useNavigate } from "react-router-dom";
import React, { useState } from "react";

import axios from "axios";




export default function Register() {
  let navigate = useNavigate();

  const [values, setValues] = useState({
    firstName: '',
    lastName: '',
    email: '',
    username: '',
    password:''
  });

  const handleFirstName = (event) =>{
    setValues({...values, firstName: event.target.value})
  }
  const handleLastName = (event) =>{
    setValues({...values, lastName: event.target.value})
  }
  const handleEmail = (event) =>{
    setValues({...values, email: event.target.value})
  }
  const handleUsername = (event) =>{
    setValues({...values, username: event.target.value})
  }
  const handlePassword = (event) =>{
    setValues({...values, password: event.target.value})
  }
function registerFormData(){

    axios.post('http://localhost:8080/users/register',{
      firstName: values.firstName,
      lastName: values.lastName,
      email: values.email,
      username: values.username,
      password: values.password
    })
    .then(response => {redirectTologin(response.status)
  }).catch(err => console.log(err))


  function redirectTologin(status){

    if(status === 200){
      
      navigate("/");
    
  
    }else alert("Sorry Wrong login")
  }
  

}


  return (
    <div className="login">
      <div className="loginWrapper">
        <div className="loginLeft">
          <h3 className="loginLogo">Lamasocial</h3>
          <span className="loginDesc">
         
          </span>
        </div>
        <div className="loginRight">
          <div className="loginBox">
          <input placeholder="First Name" className="loginInput" onChange={handleFirstName} value={values.firstName}/>
          <input placeholder="last Name" className="loginInput" onChange={handleLastName} value={values.lastName}/>
          <input placeholder="Email" className="loginInput" onChange={handleEmail} value={values.email}/>
            <input placeholder="Username" className="loginInput" onChange={handleUsername} value={values.username}/>
            <input placeholder="Password" className="loginInput" onChange={handlePassword} value={values.password}/>
            
            <button className="loginButton" onClick={registerFormData}>Register</button>
           

        
           
          </div>
        </div>
      </div>
    </div>
  );
}
