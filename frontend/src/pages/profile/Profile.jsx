import { useState, useEffect } from "react";
import "./profile.scss";
import Topbar from "../../components/topbar/Topbar";
import Feed from "../../components/feed/Feed";
import Uploader from "../../components/imageUploader/Uploader";
import axios from "axios";
import Boy from "./boy.jpeg";
import BG from "./3.jpeg";


export default function Profile() {
  const [profi, setProfi] = useState([]);

  let username = sessionStorage.getItem("Name");

  useEffect(() => {
    axios.get(`http://localhost:7070/users/username/${username}`,)
      .then(response => {
        setProfi(response.data);
      })
      .catch(err => console.log(err))
  }, [])
  console.log(profi);

  return (
    <>
      <Topbar />
      <div className="profile">
        <div className="profileRight">
          <div className="profileRightTop">
            <div className="profileCover">
              <img
                className="profileCoverImg"
                src={3}
                alt={3}
              />
              <img
                className="profileUserImg"
                src={Boy}
                alt={Boy}
              />
            </div>
            <div className="profileInfo">
              <h4 className="profileInfoName">{profi.firstName} {profi.lastName}</h4>
              <span className="profileInfoDesc">Green tea is the best tea!</span>
            </div>
          </div>
          <div className="profileRightBottom">
            <div className="profi">
              <div className="profiWrapper">
                <div className="profiTop">
                  <h3>Profile Information</h3>
                  <p>First Name: <span>{profi.firstName}</span> </p>
                  <p>Last Name: <span>{profi.lastName}</span></p>
                  <p>Username: <span>{profi.username}</span></p>
                  <p>Email: <span>{profi.email}</span></p>
                </div>
                <Uploader/>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
