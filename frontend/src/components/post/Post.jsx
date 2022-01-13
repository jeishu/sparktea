import "./post.scss";
import React, { Fragment } from 'react'
import { useState, useEffect } from "react";
import axios from "axios";
import ReadOnlyPost from "./ReadOnlyPost";
import EditablePost from "./EditablePost";


//{post}
export default function Post() {
  const [posts, setPosts] = useState([]);
  const [addPostData, setAddPostData] = useState({ content: "", date: "" });
  const [editPostData, setEditPostData] = useState({ content: "" });
  const [editPostId, setEditPostId] = useState(null);
  const handleAddPostChange = (event) => {
    event.preventDefault();
    const fieldName = event.target.getAttribute('name')
    const fieldValue = event.target.value;
    const newPostData = { ...addPostData};
     newPostData[fieldName] = fieldValue;
     setAddPostData(newPostData);
  
  }
  



  useEffect(() => {
    axios.get("http://localhost:7070/posts",)
 
      .then(response => setPosts(response.data) )
     
      .catch(err => console.log(err))
  }, [])



const handleEditClick = (event, content,id,date)=>{
  event.preventDefault();

  setEditPostId(id)

  const editPostValues = {
    content: content,
    date: date
  
  
  }
  setEditPostData(editPostValues);
  
}
const handleEditPostChange= (event) =>{
  event.preventDefault();

  const fieldName = event.target.getAttribute("name");
  const fieldValue = event.target.value;

  const newPostData = {...editPostData};
  newPostData[fieldName] = fieldValue;
setEditPostData(newPostData);
}



  return (
    <>
      <div className="post-container">
        {posts.map(({ content, date, id }) => ( 
       
        <Fragment >
{editPostId === id ? (
<EditablePost editPostData={editPostData } handleEditPostChange={handleEditPostChange}/> 
):
( <ReadOnlyPost id={id} date={date} content={content} posts={posts} handleEditClick={handleEditClick}/>
)}
         </Fragment>

        ))}
      </div>
      
    </>
  );
}
