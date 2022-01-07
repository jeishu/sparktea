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
  
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/profile" element={<Profile />}/>
          <Route path="/login-register" element={<LoginSignUp/>} />
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App;
