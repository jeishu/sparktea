import React from 'react'
import { Link, Outlet } from 'react-router-dom';
import "./nav.scss";
import Dashboard from '../../img/nav/Dashboard';
import Home from '../../img/nav/Home';
import Profile from '../../img/nav/Profile';
import Signout from '../../img/nav/Signout';

function Navbar() {
    return (
        <div className='nav-bar'>
            <Link to="/home"><Home/></Link> 
            <Link to="/profile"><Profile/></Link>
            <Link to="/signout"><Signout/></Link>
            <Outlet/>
        </div>
    )
}
export default Navbar
