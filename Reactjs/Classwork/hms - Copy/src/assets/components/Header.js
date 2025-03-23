import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
  let hmenuseparator = " | ";
  return (
    <div className='App'>
      <div className='App-header'>
        <div className='App-header-part1'>
          Hospital Logo
        </div>
        <div className='App-header-part2'>
          Hospital Management System
        </div>
        <div className='App-header-part3'>
          <Link to="/" className='classli'>Dashboard</Link> {hmenuseparator}
          <Link to="/patients" className='classli'>Patients</Link> {hmenuseparator}
          <Link to="/appointments" className='classli'>Appointments</Link>
        </div>
      </div>
      <div className='App-content'>
        <h1>App content area</h1>
      </div>
      <div className='App-foooter'>
        <div className='App-footer-part1'>
          &copy; 2025 My Website. All rights reserved.
        </div>        
        <div className="App-footer-part2">
          <a href="https://facebook.com" style={{ target: "_blank", color: "white" }} >Facebook</a> {hmenuseparator}
          <a href="https://twitter.com"  style={{ target: "_blank", color: "white" }} >Twitter</a> {hmenuseparator}
          <a href="https://linkedin.com" style={{ target: "_blank" , color: "white"}} >LinkedIn</a>
        </div>
      </div>
    </div>

  );
};

export default Header;
