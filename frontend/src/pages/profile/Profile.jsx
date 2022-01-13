import { useState, useEffect } from "react";
import "./profile.scss";
import Topbar from "../../components/topbar/Topbar";
import Uploader from "../../components/imageUploader/Uploader";
import axios from "axios";
import Boy from "./boy.png";
import BG from "./3.png";

export default function Profile() {
  const [profi, setProfi] = useState([]);
  const [updateProfile, setUpdateProfile] = useState(true);
  const [update, setUpdate] = useState({
    firstName: '',
    lastName: '',
    email: '',
    username: '',
    password: '',
    gender: '',
    dob: ''
  });
  const [picture, setPicture] = useState("");

  let id = sessionStorage.getItem("userID");
  let profilephoto = sessionStorage.getItem("Picture");
  let username = sessionStorage.getItem("Name");

  const updateDiv = () => setUpdateProfile(!updateProfile);

  const handleUpdateFirst = (e) => { setUpdate({ ...update, firstName: e.target.value }) }
  const handleUpdateLast = (e) => { setUpdate({ ...update, lastName: e.target.value }) }
  const handleUpdateEmail = (e) => { setUpdate({ ...update, email: e.target.value }) }
  const handleUpdateGender = (e) => { setUpdate({ ...update, gender: e.target.value }) }
  const handleUpdateDOB = (e) => { setUpdate({ ...update, dob: e.target.value }) }

  useEffect(() => {
    axios.get(`http://localhost:7070/users/username/${username}`)
      .then(response => {
        setProfi(response.data);
      })
      .catch(err => console.log(err))
  }, [])

  //Update(put) request for updating user profile
  const handleUpdateUser = () => {
    axios.put(`http://localhost:7070/users/update/`, {
      ...setUpdate,
      username: username,
      firstName: update.firstName,
      lastName: update.lastName,
      email: update.email,
      dob: update.dob,
      gender: update.gender
    }).then(response => {
      console.log(response.data)
    }).catch(err => console.log(err))
    //console.log(update);
  }

  //update profile pic
  useEffect(() => {
    fetch(`http://localhost:7070/users/photoloc/${id}`,
      {
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
          profilepic: profilephoto
        })
      })
      setPicture(profilephoto);
  }, [picture])

  // useEffect(() => {
  //   axios.post(`http://localhost:7070/users/photoloc/${id}`, setPicture(profilephoto))
  //   .then(response => {
  //     console.log(response.data)
  //   }).catch(err => console.log(err))
  //   //console.log(update);
  // }, [])

  // useEffect(() => {
  //   axios.put(`http://localhost:7070/users/update/profilepic`, setPicture(profilephoto))
  //   .then(response => {
  //     console.log(response.data)
  //   }).catch(err => console.log(err))
  //   //console.log(update);
  // }, [])



  const ProfileInfo = () => (
    <div>
      <p>First Name: <span>{profi.firstName}</span> </p>
      <p>Last Name: <span>{profi.lastName}</span></p>
      <p>Username: <span>{profi.username}</span></p>
      <p>Email: <span>{profi.email}</span></p>
      <p>Gender: <span>{profi.gender}</span></p>
      <p>DOB: <span>{profi.dob}</span></p>
    </div>
  )

  return (
    <>
      <Topbar />
      <div className="profile">
        <div className="profileRight">
          <div className="profileRightTop">
            <div className="profileCover">
              <img className="profileCoverImg" src={BG} alt={BG} />
              <img className="profileUserImg" src={picture} alt={update.profilepic} />
              <Uploader />
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
                  <div>
                    <button className="profile-sub-button" onClick={updateDiv}>Update Profile</button>
                    {updateProfile ?
                      <ProfileInfo />
                      :
                      <div>
                        <form className="update-profile-form">
                          <label>First Name:</label>
                          <input type="text" placeholder="First Name" value={update.firstName} onChange={handleUpdateFirst} />
                          <label>Last Name:</label>
                          <input type="text" placeholder="Last Name" value={update.lastName} onChange={handleUpdateLast} />
                          <label>Email:</label>
                          <input type="text" placeholder="Email" value={update.email} onChange={handleUpdateEmail} />
                          <label>Date of Birth:</label>
                          <input type="date" placeholder="Date of Birth" value={update.dob} onChange={handleUpdateDOB} />
                          <label>Gender:</label>
                          <select name="gender" placeholder="gender" value={update.gender} onChange={handleUpdateGender}>
                            <option value="" disabled></option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="others">Others</option>
                          </select>
                          <button className="profile-sub-button" onClick={handleUpdateUser}>Submit Changes</button>
                        </form>
                      </div>
                    }
                  </div>
                </div>
              </div>
            </div>
            <div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
