import React from "react";
import "./styles.css";
import logo from "../logo.png";

const Header = ({ onLogout }) => {
  return (
    <header className="header">
      <div className="logo">
        <img src={logo} alt="Logo" />
        <span className="title">System Punchline</span>
      </div>
      <div className="title">Dummy System Punchline</div>
      <button className="logout-btn" onClick={onLogout}>Logout</button>
    </header>
  );
};

export default Header;
