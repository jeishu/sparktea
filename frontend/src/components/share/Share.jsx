import "./share.css";
import { useState } from "react";
import axios from "axios";
import moment from "moment";
import Boy from "./boy.jpeg";

export default function Share() {
  const [values, setValues] = useState({ contnt: "", dat: "" });

  let time = moment().format("MMM Do YYYY, h:mm a");
  console.log(time)

  const handleTextChange = (event) => {
    setValues({...values, contnt: event.target.value, dat: time});
    console.log(values)
  }

  const registerTextData = () => {
    axios.post("http://localhost:7070/posts/create", {
      contnt: values.contnt,
      date: values.dat
    }).then(response => {
      console.log(response.status)
      console.log(response.data)
    }).catch(error => console.log(error))
      
    window.location.reload(true);
  }

  return (
    <div className="share">
      <div className="shareWrapper">
        <div className="shareTop">
          <img className="shareProfileImg" src={Boy} alt={Boy} />
          <input
            placeholder="What's sparking in your mind today?"
            className="shareInput"
            value={values.contnt}
            onChange={handleTextChange}
          />
        </div>
        <hr className="shareHr" />
        <div className="shareBottom">
          <div className="shareOptions">
            <div className="shareOption">
              <button onClick={registerTextData} className="shareButton">Spark</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
