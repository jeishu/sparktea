import React from "react"
import axios from "axios"

const EditablePost =({content,date,id}) => {
    
    function deleteTextData(id){
        axios.delete(`http://localhost:7070/posts/delete/${id}`)
      
        .then(response => {
          console.log(response.status)
          console.log(response.data)
        }).catch(error => console.log(error))
          
        window.location.reload(true);
      
      }
      


    return(
        <div className="post" key={id}>
<div className="postWrapper">
    <div className="postTop">
      <p className="content">{content}</p>
      <p className="date">{date}</p>
      <input
            placeholder="Edit post?"
            className="shareInput"
          
          />
      <button className="deleteButton" onClick={()=> deleteTextData(id)}>Delete</button>
    </div>
  </div>
  </div>
    );

};

export default EditablePost;