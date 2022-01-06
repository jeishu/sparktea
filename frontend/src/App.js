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

  //check for loggin

  return (
    <div className="App">
      <LoginSignUp />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginSignUp />} />
          <Route path="/pages/home/Home" element={<Home />} />
          <Route path="/pages/profile/Profile" element={<Profile />} />
          {/* <Route path="/pages/register/Register" element={<Register />} /> */}
        </Routes>
      </BrowserRouter>          

    </div>
  )
}

export default App;
