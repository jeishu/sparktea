import React from 'react'
// import 'react-dropzone-uploader/dist/styles.css'
import Dropzone from 'react-dropzone-uploader'
import axios from 'axios'

const Uploader = () => {
    const API_ENDPOINT = "https://kicko26hfd.execute-api.us-east-2.amazonaws.com/default/getPresignedImageURL"
  

    const handleChangeStatus = ({ meta, remove }, status) => {
        console.log(status, meta);
    }

    const handleSubmit = async (files) => {
        const f = files[0];
        console.log(f['file']);
        // GET REQUEST : PRESIGNED URL
        const response = await axios({
            method: 'GET',
            url: API_ENDPOINT
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
        console.log('Result: ', result)

    }

    return (

        <Dropzone
            onChangeStatus={handleChangeStatus}
            onSubmit={handleSubmit}
            maxFiles={1}
            multiple={false}
            canCancel={false}
            inputContent="Drop A File"
            styles={{
                dropzone: { width: 400, height: 200 },
                dropzoneActive: { borderColor: 'green' },
            }}
        />
    )
}

<Uploader />

export default Uploader
