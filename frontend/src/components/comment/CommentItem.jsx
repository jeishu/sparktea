import React from 'react'
import { useState, useEffect, useContext } from "react";
import axios from "axios";
import moment from "moment";

export default function CommentItem(props) {
  const [postComments, setPostComments] = useState({ contnt: "", dat: "" });

  let username = sessionStorage.getItem("Name");  
  let userID = sessionStorage.getItem("userID");

  let time = moment().format("h:mm a");
  //console.log(time)

  const handleComment = (event) => {setPostComments({ contnt: event.target.value, dat: time })}

  //Comment information
  const commentData = () => {
    axios.post("http://localhost:7070/comments/create", {
      contnt: postComments.contnt,
      date: time,
      username: username,
      userid: userID,
      postid: props.itemID
    }).then(response => {
      console.log(response.status)
      console.log(response.data)
    }).catch(error => console.log(error))

    window.location.reload(true);
    // console.log(postComments);
  }

  //Getting all comments
  useEffect(() => {
    axios.get("http://localhost:7070/comments",)
      .then(response => {
        setPostComments(response.data)
        //console.log(response.data)
      })
      .catch(err => console.log(err))
  }, [])


  return (

    <>
      <div className="postWrapper">
        <div className="postTop">

          <p className="content">{props.itemContnt}</p>
          <p className="date">{props.itemDate}</p>
          <p className="username">{props.itemUsername}</p>
        </div>
      </div>

      <input
        placeholder="What's your sparking comment?"
        className="shareInput"
        value={postComments.contnt}
        onChange={handleComment}
      />

      <button onClick={commentData} className="commentButton">Comment</button>
    </>

  )
}
