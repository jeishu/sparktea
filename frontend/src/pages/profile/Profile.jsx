import { useState, useEffect } from "react";
import "./profile.scss";
import Topbar from "../../components/topbar/Topbar";
import Uploader from "../../components/imageUploader/Uploader";
import axios from "axios";
import Boy from "./boy.png";
import BG from "./3.png";


export default function Profile() {
  const [profi, setProfi] = useState([]);
  const [update, setUpdate] = useState({
    firstName: '',
    lastName: '',
    email: '',
    username: '',
    password: '',
    gender: '',
    dob: '',
  });

  let username = sessionStorage.getItem("Name");

//   Get request by id ==> return first name
// Need to access session storage to print first name


  useEffect(() => {
    axios.get(`http://localhost:7070/users/username/${username}`,)
      .then(response => {
        setProfi(response.data);
      })
      .catch(err => console.log(err))
  }, [])

  //Update(put) request for updating user profile
  const handleUpdateUser = () => {
    axios.put(`http://localhost:7070/users/update/${username}`,{
      ...setUpdate,
      firstName: '',
      lastName: '',
      username: '',
      email: '',
      dob: '',
      gender: ''
    })
    .then(response => {

      })
    .catch(err => console.log(err))
  }


  return (
    <>
      <Topbar />
      <div className="profile">
        <div className="profileRight">
          <div className="profileRightTop">
            <div className="profileCover">
              <img className="profileCoverImg" src={BG} alt={BG} />
              <img className="profileUserImg" src={Boy} alt={Boy} />
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
                  <p>Gender: <span>{profi.gender}</span></p>
                  <p>DOB: <span>{profi.dob}</span></p>
                  <button className="edit-profile-button">Edit Profile</button>
                </div>
                <Uploader/>
              </div>
            </div>
            <div>
              <form>
                <input type="text" value={update.firstName} onChange={e => setUpdate()} />
              </form>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
