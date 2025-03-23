import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css"; // Make sure to link the correct CSS file

const Navbar = () => {
    return (
        <nav className="navbar">
            <Link to="/dashboard" className="menu-item">Dashboard</Link>
            <Link to="/patients" className="menu-item">Patients</Link>
            <Link to="/appointments" className="menu-item">Appointments</Link>
            <Link to="/billing" className="menu-item">Billing</Link>
            <Link to="/reports" className="menu-item">Reports</Link>
        </nav>
    );
};

export default Navbar;
