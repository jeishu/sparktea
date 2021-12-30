import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/pages/Home';
import LoginSignUp from './components/pages/LoginSignUp';
import Profile from './components/pages/Profile';
import Navbar from "./components/navbar/Navbar"
import "./scss/index.scss"

function App() {
  return (
    <div className="App">
      <LoginSignUp/>
      {/* <BrowserRouter>
        <Routes >
          <Route path="/" element={<Navbar/>}>
            <Route path="home" element={<Home/>}/>
            <Route path="login" element={<Login/>}/>
            <Route path="profile" element={<Profile/>}/>
          </Route>
        </Routes>
      </BrowserRouter> */}
    </div>
  );
}

export default App;
