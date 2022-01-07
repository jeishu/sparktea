import "./post.css";
import { useState, useEffect } from "react";
import axios from "axios";

//{post}
export default function Post() {
  const [posts, setPosts] = useState([]);

  // useEffect(()=> {
  //   fetch('http://localhost:7070/post', {
  //     method: "POST",
  //     mode: "same-origin"
  //   }).then(
  //     result => {
  //       setPosts(result.data)
  //       console.log(result);
  //     }
  //   ).catch(err => console.log(err));
  // },[])

  useEffect( () => {
     axios.get("http://localhost:7070/posts",)
      .then(response => {
        setPosts(response.data);
        // console.log(response.data[0].contnt);
      })
      .catch(err => console.log(err))
  }, [])
  console.log(posts);

  return (
    <>
      {posts.map(({contnt, date, id}) => (
        <div className="post" key={id}>
          <div className="postWrapper">
            <div className="postTop">
              <p>{contnt}</p>
              <p>{date}</p>
            </div>
          </div>
        </div>
      ))}
    </>
  );
}
