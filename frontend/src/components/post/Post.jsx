import "./post.scss";
import { useState, useEffect, useContext } from "react";
import axios from "axios";
import moment from "moment";
import CommentItem from "../comment/CommentItem";

// import { MoreVert } from "@material-ui/icons";
// import { format } from "timeago.js";
// import { Link } from "react-router-dom";
// import { AuthContext } from "../../context/AuthContext";


//{post}
export default function Post() {
  const [posts, setPosts] = useState([]);

  let userid = sessionStorage.getItem("userid");

  // const [comments, setComments] = useState({ contnt: "", dat: "" });

  let time = moment().format("h:mm a");
  console.log(time)

  // const handleComment = (event) => {
  //   setComments({ contnt: event.target.value, dat: time });
  //   console.log(comments)
  // }


  // const [like, setLike] = useState(posts.likes.length);
  // const [isLiked, setIsLiked] = useState(false);

  // const [user, setUser] = useState({});
  // const PF = process.env.REACT_APP_PUBLIC_FOLDER;
  // const { user: currentUser } = useContext(AuthContext);

  // useEffect(() => {
  //   setIsLiked(posts.likes.includes(currentUser._id));
  // }, [currentUser._id, posts.likes]);

  // useEffect(() => {
  //   const fetchUser = async () => {
  //     const res = await axios.get(`/users?userId=${posts.userId}`);
  //     setUser(res.data);
  //   };
  //   fetchUser();
  // }, [posts.userId]);

  // const likeHandler = () => {
  //   try {
  //     axios.put("/posts/" + posts._id + "/like", { userId: currentUser._id });
  //   } catch (err) { }
  //   setLike(isLiked ? like - 1 : like + 1);
  //   setIsLiked(!isLiked);
  // };

  useEffect(() => {
    axios.get("http://localhost:7070/posts",)
      .then(response => {
        setPosts(response.data)
        console.log(response.data)
      })
      .catch(err => console.log(err))
  }, [])

  // function postAuthor () {
  //   axios.get(`http://localhost:7070/posts/userid/${userid}`,)
  //     .then(response => {
  //       setProfi(response.data);
  //     })
  //     .catch(err => console.log(err))
  // }
  // console.log(profi);

  // const commentData = () => {
  //   axios.post("http://localhost:7070/comments/create", {
  //     contnt: comments.contnt,
  //     date: comments.dat
  //   }).then(response => {
  //     console.log(response.status)
  //     console.log(response.data)
  //   }).catch(error => console.log(error))

  //   window.location.reload(true);
  //   console.log(comments);
  // }

  // useEffect(() => {
  //   axios.get("http://localhost:7070/comments",)
  //     .then(response => setComments(response.data))
  //     .catch(err => console.log(err))
  // }, [])

  return (
    <>
      <div className="post-container">
        {posts.map(({ contnt, date, id, userid }) => (
          <div className="post" key={id}>
            {/* <div className="postWrapper">
              <div className="postTop"> */}

                {/* <img
                  className="likeIcon"
                  src={`${PF}like.png`}
                  onClick={likeHandler}
                  alt=""
                />
            <span className="postLikeCounter">{like} people like it</span> */}


                {/* <p className="content">{contnt}</p>
                <p className="date">{date}</p>
              </div>
            </div>

              <input
              placeholder="What's your sparking comment?"
              className="shareInput"
              value={comments.contnt}
              onChange={handleComment}
            /> */}

                {/* <div className="comment-container"> */}
                  {/* {comments.map(({ contnt, date, id }) => (
                   <div className="post" key={id}> 
                   <div className="postWrapper"> 
                   <div className="postTop"> 
                   <p className="content">{contnt}</p> 
                   <p className="date">{date}</p> 
                 </div> 
                 </div> 
                 ))} */}
                
              
              {/* <button onClick={commentData} className="commentButton">Comment</button> */}
              <CommentItem itemDate={date} itemContnt={contnt} itemUserid={userid}/>
          </div>
        ))}
    </div>
    </>
  );
}
