import React from 'react'
import { useState, useEffect } from "react";
import axios from "axios";

function Comment(props) {
    const [allComments, setAllComments] = useState([]);

    //Getting all comments
    useEffect(() => {
        axios.get("http://localhost:7070/comments",)
            .then(response => {
                setAllComments(response.data)
                console.log(response.data)
            })
            .catch(err => console.log(err))
    }, [])

    const filterComments = allComments.map(({ username, contnt, date, postid }) => {
        if (postid === props.postId) {
            return (
                <div className="comment">
                    <p className='comment-username'>{username} <span>{date}</span></p>
                    <p className='comment-content'>{contnt}</p>
                </div>
            )
        }
    })

    return (
        <div className="comment-wrapper">
            {filterComments}
        </div>
    )
}

export default Comment
