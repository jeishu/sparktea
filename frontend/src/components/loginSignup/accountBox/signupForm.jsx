import React, { useContext, useState } from "react";
import {
  BoldLink,
  BoxContainer,
  FormContainer,
  Input,
  MutedLink,
  SubmitButton,
} from "./common";
import { Marginer } from "../marginer/Marginer";
import { AccountContext } from "./accountContext";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export function SignupForm(props) {
  const { switchToSignin } = useContext(AccountContext);

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
    <BoxContainer>
      <FormContainer>
        <Input type="text" onChange={handleFirstName} name="firstname" placeholder="First Name" value={values.firstName} />
        <Input type="text" onChange={handleLastName} name="lastname" placeholder="Last Name" value={values.lastName} />
        <Input type="email" name="email" onChange={handleEmail} placeholder="Email" value={values.email} />
        <Input type="username" name="username" onChange={handleUsername} placeholder="Username" value={values.username} />
        <Input type="password" name="password" onChange={handlePassword} placeholder="Password" value={values.password} />
    
      </FormContainer>
      <Marginer direction="vertical" margin={10} />
      <SubmitButton type="submit" onClick={registerFormData}>Sign up</SubmitButton>
      <Marginer direction="vertical" margin="1em" />
      <MutedLink href="#">
        Already have an account?
        <BoldLink href="#" onClick={switchToSignin}>
          Sign in
        </BoldLink>

      </MutedLink>
    </BoxContainer>
  );
}