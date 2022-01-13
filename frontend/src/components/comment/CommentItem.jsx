import React from 'react'
import { useState, useEffect } from "react";
import axios from "axios";
import moment from "moment";
import "./comment.scss"
import Comment from './Comment';

export default function CommentItem(props) {
  const [postComments, setPostComments] = useState({ contnt: "", dat: "" });
  const [showComments, setShowComments] = useState(true);

  let username = sessionStorage.getItem("Name");
  let userID = sessionStorage.getItem("userID");

  let time = moment().format("h:mm a");
  //console.log(time)

  const handleComment = (event) => { setPostComments({ contnt: event.target.value, dat: time }) }
  const handleShowComment = () => setShowComments(!showComments);

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
  }

  //Getting all comments
  useEffect(() => {
    axios.get("http://localhost:7070/comments",)
      .then(response => {
        setPostComments(response.data)
      })
      .catch(err => console.log(err))
  }, [])


  return (
    <>
      <button className='comment-hide' onClick={handleShowComment}>Comment some tea?</button>
      {showComments ? <></> :
        <div>
          <div className="comment-container">
            <input
              placeholder="What's your sparking comment?"
              className="comment-input"
              value={postComments.contnt}
              onChange={handleComment}
            />
            <button onClick={commentData} className="comment-button">Comment</button>
          </div>

          <Comment postId={props.itemID} />

        </div>

      }
    </>
  )
}
