import "./post.scss";
import { useState, useEffect } from "react";
import axios from "axios";
import CommentItem from "../comment/CommentItem";

//{post}
export default function Post() {
  const [posts, setPosts] = useState([]);

  let userID = sessionStorage.getItem("userID");

  useEffect(() => {
    axios.get("http://localhost:7070/posts")
      .then(response => {
        setPosts(response.data)
        console.log(response)
      })
      .catch(err => console.log(err))
  }, [])
  console.log(posts)

  const deleteTextData = (id) => {
    axios.delete(`http://localhost:7070/posts/delete/${id}`)
      .then(response => {
        console.log(response.status)
        console.log(response.data)
      }).catch(error => console.log(error))

    window.location.reload(true);
  }

  return (
    <>
      <div className="post-container">
        {posts.map(({ contnt, date, id, username }) => (
          <div className="post" key={id}>
            <div className="postWrapper">
              <div className="postTop">
                <div className="post-top-con">
                  <p className="username">{username}</p>
                  <p className="date">{date}</p>
                </div>
                <button className="delete-button" onClick={() => deleteTextData(id)}>X</button>
              </div>
              <p className="content">{contnt}</p>
            </div>
            <CommentItem itemID={id} itemDate={date} itemContnt={contnt} itemUsername={username} itemUserID={userID} />
          </div>
        ))}
      </div>
    </>
  );
}
