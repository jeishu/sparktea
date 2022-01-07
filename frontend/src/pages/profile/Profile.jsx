import "./profile.css";
import Topbar from "../../components/topbar/Topbar";
import Feed from "../../components/feed/Feed";
import Uploader from "../../components/imageUploader/Uploader";
import { useState, useEffect } from "react";
import axios from "axios";

export default function Profile() {

  const [profi, setProfi] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:7070/users/id/{id}",)
      .then(response => {
        setProfi(response.data);
        // console.log(response.data.);
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
                src="assets/post/3.jpeg"
                alt=""
              />
              <img
                className="profileUserImg"
                src="assets/person/7.jpeg"
                alt=""
              />
            </div>
            <div className="profileInfo">
              <h4 className="profileInfoName">Safak Kocaoglu</h4>
              <span className="profileInfoDesc">Hello my friends!</span>
            </div>
          </div>
          <div className="profileRightBottom">
            {/* <Feed /> */}
            <Uploader />

            {profi.map(({ id, username, firstname, lastname, email }) => (
              <div className="profi" key={id}>
                <div className="profiWrapper">
                  <div className="profiTop">
                    <p>{username}</p>
                    <p>{firstname}</p>
                    <p>{lastname}</p>
                    <p>{email}</p>
                  </div>
                </div>
              </div>
            ))}

          </div>
        </div>
      </div>
    </>
  );
}
