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
  
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/home" element={<Home />}/>
          <Route path="/profile" element={<Profile />}/>
          <Route path="/" element={<LoginSignUp/>} />
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App;
