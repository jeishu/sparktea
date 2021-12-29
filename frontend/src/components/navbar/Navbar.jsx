import React from 'react'
import {Link, Outlet} from 'react-router-dom';

function Navbar() {
    return (
        <div>
            <h1>Navbar</h1>
            <Link to="/home">Home</Link> 
            {" | "}
            <Link to="/profile">profile</Link>
            <hr/>
            <Outlet/>
        </div>
    )
}
export default Navbar
