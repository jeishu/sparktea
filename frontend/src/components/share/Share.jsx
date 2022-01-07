import "./share.css";
import { useState } from "react";
import axios from "axios"; 

export default function Share() {
  const [values,setValues] = useState({contnt:""});
  // const [user,setUser] = useState({ })
  const [date,setDate] = useState({dat:""});

  var today = new Date();
  var dates = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
  var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
  var dateTime = dates+' '+time;

  console.log(typeof dateTime);

  const handleTextChange= (event) => {
    setValues({
      ...values,
      contnt: event.target.value
    });
    setDate({
      ...date, 
      dat:dateTime 
    });
  }
  
  function registerTextData(){
    axios.post("http://localhost:7070/posts/create",{
      contnt:values.contnt,
      dat:date.dat
    }).then(response =>{console.log(response.status)})
    .catch(error => console.log(error))
  }

  return (
    <div className="share">
      <div className="shareWrapper">
        <div className="shareTop">
          <img className="shareProfileImg" src="/assets/person/1.jpeg" alt="" />
          <input
            placeholder="What's sparking in your mind today?"
            className="shareInput"
            value={values.contnt}
            onChange={handleTextChange}
          />
        </div>
        <hr className="shareHr"/>
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
