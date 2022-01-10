import "./post.scss";
import { useState, useEffect } from "react";
import axios from "axios";

//{post}
export default function Post() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:7070/posts",)
      .then(response => setPosts(response.data))
      .catch(err => console.log(err))
  }, [])

  const deleteTextData = (id) =>{
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
        {posts.map(({ contnt, date, id }) => (
          <div className="post" key={id}>
            <div className="postWrapper">
              <div className="postTop">
                <p className="date">{date}</p>
                <button className="delete-button" onClick={() => deleteTextData(id)}>X</button>
              </div>
              <p className="content">{contnt}</p>
            </div>
          </div>
        ))}
      </div>
    </>
  );
}
