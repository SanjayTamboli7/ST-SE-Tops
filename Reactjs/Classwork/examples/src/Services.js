import React from 'react';
import { Link, Outlet } from 'react-router-dom';

function Services() {
  return (
    <div>
      <Link to='/services/services1'>Service 1</Link>                
      <Link to='/services/services2'>Service 2</Link>
      <Link to='/services/services3'>Service 3</Link>
      <Outlet/>
    </div>
  )
}

export default Services
