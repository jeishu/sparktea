import React from "react"
import axios from "axios"

const ReadOnlyPost =({ id, content, date, handleEditClick,posts}) => {
    
    function deleteTextData(id){
        axios.delete(`http://localhost:7070/posts/delete/${id}`)
      
        .then(response => {
          console.log(response.status)
          console.log(response.data)
        }).catch(error => console.log(error))
          
        window.location.reload(true);
      
      }
    

    return(
  <>
   <div className="post" key={id}>
<div className="postWrapper">
<div className="postTop">
  <p>{id}</p>
      <p className="content">{content}</p>
      <p className="date">{date}</p>
    
    </div>
  </div>

  <button className="editButton" onClick={(event)=>handleEditClick(event,content,id,date)}>edit</button>
      <button className="deleteButton" onClick={()=> deleteTextData(id)}>Delete</button>
       </div>
    </>

    )};

export default ReadOnlyPost;