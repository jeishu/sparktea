import React, { useState } from 'react'
import 'react-dropzone-uploader/dist/styles.css'
import Dropzone from 'react-dropzone-uploader'
import axios from 'axios'
import "./uploader.scss";

const Uploader = () => {
    const [profile, setProfile] = useState("");
    
    const API_ENDPOINT = "https://kicko26hfd.execute-api.us-east-2.amazonaws.com/default/getPresignedImageURL"
  
    const handleChangeStatus = ({ meta }, status) => {
        console.log(status, meta);
    }

    const handleSubmit = async (files) => {
        const f = files[0];
        console.log(f['file']);
        // GET REQUEST : PRESIGNED URL
        const response = await axios({
            method: 'GET',
            url: API_ENDPOINT,
        })
        console.log('Response: ', response)

        // PUT REQUEST : UPLOAD FILE TO S3
        const result = await fetch(response.data.uploadURL, {
            method: 'PUT',
            headers: {
                "Content-Type": "image/jpeg",
            },
            body: f['file']
        })
        
        await setProfile("https://sparktea-bucket.s3.us-east-2.amazonaws.com/"+response.data.Key)
        console.log('Result: ', result)
        console.log(profile)
        await sessionStorage.setItem("Picture", profile);
        // window.location.reload(true);
    }

    return (
        <div>
            <Dropzone
            onChangeStatus={handleChangeStatus}
            onSubmit={handleSubmit}
            maxFiles={1}
            multiple={false}
            canCancel={false}
            inputContent=""
            styles={{
                dropzone: { width: 300, height: 300 },
                dropzoneActive: { borderColor: 'green' },
            }}
            />
        </div>
    )
}

<Uploader />

export default Uploader
