import React from "react"
import axios from "axios"
import {useState} from "react"
const EditablePost =({content,date,id}) => {
  const [values, setValues] = useState({content: ""});

  console.log(id)
    function deleteTextData(id){
        axios.delete(`http://localhost:7070/posts/delete/${id}`)
      
        .then(response => {
          console.log(response.status)
          console.log(response.data)
        }).catch(error => console.log(error))
          
        window.location.reload(true);
      
      }
  
      const registerUpdateData = (id) => {
        axios.put("http://localhost:7070/posts/update",{
        id: id,
        content: values.content

     
        }).then(response => {
          console.log(response.status)
          console.log(response.data)
        }).catch(error => console.log(error))
        console.log(id);
         window.location.reload(true);
      }
      const handleEditPostChange= (event) =>{
             
        setValues({...values, content: event.target.value});
      
       
     
      }
    return(
        <div className="post" key={id}>
<div className="postWrapper">
    <div className="postTop">
      <p className="content">{content}</p>
      <p className="date">{date}</p>
      <input
            placeholder="Edit post?"
            name="shareInput"
            value={values.content}
            onChange={handleEditPostChange}
          
          />

    </div>
  </div>
  <button className="editButton" onClick={registerUpdateData(id)}>save</button>
      <button className="deleteButton" onClick={()=> deleteTextData(id)}>Delete</button>
  </div>
    );

};

export default EditablePost;