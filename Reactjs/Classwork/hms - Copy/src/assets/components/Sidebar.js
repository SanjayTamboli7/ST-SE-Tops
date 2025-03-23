import React from 'react';
import { Link } from 'react-router-dom';

const Sidebar = () => {
  return (
    <div className="sidebar">
      <ul>
        <li><Link to="/patients" className='classli'>Patients</Link></li>
        <li><Link to="/appointments" className='classli'>Appointments</Link></li>
      </ul>
    </div>
  );
};

export default Sidebar;
