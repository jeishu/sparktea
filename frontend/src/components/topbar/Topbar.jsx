import "./topbar.scss";
import { Link, useLocation } from "react-router-dom";
import Logo from "./logo.png";

export default function Topbar() {
  const location = useLocation();

  //Removing the localstorage when the user signs out.
  const sessionStorageRemove = () => {
    sessionStorage.removeItem("Name");
    console.log("Session storage cleared.")
  }

  return (
    <div className="topbarContainer">
      <div className="topbarLeft">
        <img className="logo-image" src={Logo} alt={Logo} />
        <Link className="logo" to="/">SparkTea</Link>
      </div>
      <div className="topbarCenter">
      </div>
      <div className="topbarRight">
        <div className="topbarLinks">
          <Link className={location.pathname === "/" ? "active" : "non-active"} to="/">HOME</Link>
          <Link className={location.pathname === "/profile" ? "active" : "non-active"} to="/profile">PROFILE</Link>
          <Link className={location.pathname === "/login-register" ? "active" : "non-active"} to="/login-register" onClick={sessionStorageRemove}>LOGOUT</Link>
        </div>
        <img src="/assets/person/1.jpeg" alt="" className="topbarImg"/>
      </div>
    </div>
  );
}
