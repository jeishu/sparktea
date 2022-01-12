import React, { useContext, useState } from "react";
import axios from "axios"
import { useNavigate } from "react-router-dom";
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
import { RestoreTwoTone } from "@material-ui/icons";

export function LoginForm(props) {
  const { switchToSignup } = useContext(AccountContext);
  const [values, setValues] = useState({
    firstName: '',
    lastName: '',
    email: '',
    username: '',
    password: ''
  });
  const [name, setName] = useState("");

  let navigate = useNavigate();

  const handleUsername = (event) => {
    setValues({...values, username: event.target.value});
    setName(event.target.value);
  }

  const handlePassword = (event) => {setValues({ ...values, password: event.target.value })};

  function loginFormData() {
    var userID = 0;
    axios.post('http://localhost:7070/users/login', {
      username: values.username,
      password: values.password
    }).then(res => { 
        console.log(res.data)
        // setUserID(res.data.userId);
        userID = res.data.userId;
        console.log(userID)
        redirectToHome(res.status);
        sessionStorageSetItem();
        //console.log(name)
    }).catch(err => console.log(err));

    function redirectToHome(status) {
      if (status === 200) navigate("/");
      else navigate("/login-register");
    }
    const sessionStorageSetItem = () => {
      sessionStorage.setItem("userID", userID);
      sessionStorage.setItem("Name", name);
    }
  }

  return (
    <BoxContainer>
      <FormContainer>
        <Input type="username" placeholder="Username" onChange={handleUsername} value={values.username} />
        <Input type="password" placeholder="Password" onChange={handlePassword} value={values.password} />
      </FormContainer>
      <Marginer direction="vertical" margin={10} />
      <Marginer direction="vertical" margin="1.6em" />
      <SubmitButton type="submit" onClick={loginFormData}>Login</SubmitButton>
      <Marginer direction="vertical" margin="1em" />
      {/* <MutedLink href="#">Forget your password?</MutedLink> */}
      <MutedLink href="#">
        Don't have an account?{" "}
        <BoldLink href="#" onClick={switchToSignup}>
          Sign up
        </BoldLink>
      </MutedLink>
    </BoxContainer>
  );
}