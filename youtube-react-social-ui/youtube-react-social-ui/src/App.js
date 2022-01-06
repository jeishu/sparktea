import Home from "./pages/home/Home";
import Login from "./pages/login/Login";
import Profile from "./pages/profile/Profile";
import Register from "./pages/register/Register";
import React from "react";
import {BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
  
  <React.Fragment>
      <BrowserRouter><Routes>
  
        <Route  path="/" element={<Login/>}/>
        <Route  path="/pages/home/Home" element={<Home/>}/>
        <Route  path="/pages/profile/Profile" element={<Profile/>}/>
        <Route  path="/pages/register/Register" element={<Register/>}/>
      
      </Routes>

      </BrowserRouter>
  
</React.Fragment>)
}

export default App;
