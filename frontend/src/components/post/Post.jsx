import "./post.scss";
import { useState, useEffect } from "react";
import axios from "axios";

//{post}
export default function Post() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:7070/posts",)
 
      .then(response => setPosts(response.data) )
     
      .catch(err => console.log(err))
  }, [])

function deleteTextData(id){
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
        {posts.map(({ content, date, id }) => (
          <div className="post" key={id}>
            <div className="postWrapper">
              <div className="postTop">
                <p className="content">{content}</p>
                <p className="date">{date}</p>
                <button className="deleteButton" onClick={()=> deleteTextData(id)}>Delete</button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </>
  );
}
