import Home from "./pages/home/Home";
import LoginSignUp from "./pages/loginSignup/LoginSignUp";
import Profile from "./pages/profile/Profile";
import {
  BrowserRouter,
  Route,
  Routes
} from "react-router-dom";
import "./scss/index.scss";
import Uploader from "./components/imageUploader/Uploader"

function App() {

  //check for loggin

  return (
    <div className="App">
      <Uploader/>

      {/* <LoginSignUp /> */}
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginSignUp />} />
          <Route path="/home" element={<Home />} />
          <Route path="/profile" element={<Profile />} />
          {/* <Route path="/pages/register/Register" element={<Register />} /> */}
        </Routes>
      </BrowserRouter>          

    </div>
  )
}

export default App;
