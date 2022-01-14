import "./topbar.scss";
import { Link, useLocation } from "react-router-dom";
import Logo from "./logo.png";
import Boy from "./boy.png";

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
        <Link className="logo" to="/home">SparkTea</Link>
      </div>
      <div className="topbarRight">
        <div className="topbarLinks">
          <Link className={location.pathname === "/home" ? "active" : "non-active"} to="/home">HOME</Link>
          <Link className={location.pathname === "/profile" ? "active" : "non-active"} to="/profile">PROFILE</Link>
          <Link className={location.pathname === "/" ? "active" : "non-active"} to="/" onClick={sessionStorageRemove}>LOGOUT</Link>
        </div>
        <img src={Boy} alt={Boy} className="topbarImg"/>
      </div>
    </div>
  );
}
