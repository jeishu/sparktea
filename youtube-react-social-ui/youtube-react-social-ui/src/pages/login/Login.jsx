import "./login.css";
import React, { useState } from "react";
import axios from "axios"
import { useNavigate } from "react-router-dom";

export default function Login() {

  let navigate = useNavigate();
  
    const [values, setValues] = useState({
      firstName: '',
      lastName: '',
      email: '',
      username: '',
      password:''
    });
  

    const handleUsername = (event) =>{
      setValues({...values, username: event.target.value})
    }
    const handlePassword = (event) =>{
      setValues({...values, password: event.target.value})
    }
  function loginFormData(){
  
      axios.post('http://localhost:8080/users/login',{
        username: values.username,
        password: values.password
      })
      .then(res =>{
        redirectToHome(res.status)
    }).catch(err => console.log(err))


    function redirectToHome(status){

      if(status === 200){
        
        navigate("/pages/home/Home");
      
    
      }else alert("Sorry Wrong login")
    }
    
  }
  
function routeToRegister(){
  navigate("/pages/register/Register")
}



  return (

    <div className="login">
          
      <div className="loginWrapper">
        <div className="loginLeft">
          <h3 className="loginLogo">SparkTea</h3>
          <span className="loginDesc">
          
          </span>
        </div>
        <div className="loginRight">
          <div className="loginBox">

            <input placeholder="Username" className="loginInput" onChange={handleUsername} value={values.username}/>
            <input placeholder="Password" className="loginInput" onChange={handlePassword} value={values.password}/>
  
            <span className="loginForgot">Forgot Password?</span>
            <button className="loginRegisterButton" onClick={loginFormData} >
             Login
            </button>
               <button className="loginButton" onClick={routeToRegister} >
             Sign Up
            </button>
          </div>
        </div>
      </div>
    </div>
  );

}
