import { useState } from "react";
import Home from "./pages/home/Home";
import LoginSignUp from "./pages/loginSignup/LoginSignUp";
import Profile from "./pages/profile/Profile";
import {
  BrowserRouter,
  Route,
  Routes
} from "react-router-dom";
import "./scss/index.scss";

function App() {
  const [isLoggedIn,setIsLoggedIn] = useState(false);

  //check for loggin

  return (
    <div className="App">
<<<<<<< HEAD
        <Home/>
=======
        {/* <LoginSignUp/> */}
    {/* <BrowserRouter>
      <Routes>
        <Route component={Home} path="/" exact>
          {isLoggedIn ? <Home/> : <LoginSignUp/>}
        </Route>
        <Route component={Profile} path="/profile" exact>
          {isLoggedIn ? <Profile/> : <LoginSignUp/>}
        </Route>
      </Routes>
    </BrowserRouter> */}
      
>>>>>>> main
    </div>
  )
}

export default App;
