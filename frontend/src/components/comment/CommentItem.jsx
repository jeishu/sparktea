import React from 'react'
import { useState, useEffect, useContext } from "react";
import axios from "axios";
import moment from "moment";

export default function CommentItem(props) {
    const [postComments, setPostComments] = useState({ contnt: "", dat: "" });

    let time = moment().format("h:mm a");
    console.log(time)
  
    const handleComment = (event) => {
        setPostComments({ contnt: event.target.value, dat: time });
    //   console.log(postComments)
    }
  
    const commentData = () => {
        axios.post("http://localhost:7070/comments/create", {
          contnt: postComments.contnt,
          date: time
        }).then(response => {
          console.log(response.status)
          console.log(response.data)
        }).catch(error => console.log(error))
    
        window.location.reload(true);
        // console.log(postComments);
      }

      const postAuthor = ()  => {
        axios.get(`http://localhost:7070/users/userid/${props.itemUserid}`,)
        
          .then(response => {
            return(response.data.username);
            
          })
          .catch(err => console.log(err))
      }
      console.log(props.itemUserid)
      console.log(props.username)

    return (
      
             <>
            <div className="postWrapper">
              <div className="postTop">

                <p className="content">{props.itemContnt}</p>
                <p className="date">{props.itemDate}</p>
                <p className="username">{postAuthor}</p>
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
