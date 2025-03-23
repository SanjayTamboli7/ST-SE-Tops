import React from 'react';
import logo from '../../assets/logo.png'; // Add a logo to your assets folder
import Login from './Login';

function Header() {
  return (
    <header className="header">
      <div className="logo-container">
        <img src={logo} alt="Company Logo" className="logo" />
        <div className="company-tagline">Innovative Solutions for Tomorrow</div>
      </div>
      <div className="system-punchline">
        Empowering Your Business with Technology
      </div>
      <div className="auth-container">
        <button className="logout-btn" onClick={<Login/>} >Login</button>
        <button className="logout-btn">Logout</button>
      </div>
    </header>
  );
}

export default Header;
