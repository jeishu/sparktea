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

  return (
    <>
      <div className="post-container">
        {posts.map(({ contnt, date, id }) => (
          <div className="post" key={id}>
            <div className="postWrapper">
              <div className="postTop">
                <p className="content">{contnt}</p>
                <p className="date">{date}</p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </>
  );
}
