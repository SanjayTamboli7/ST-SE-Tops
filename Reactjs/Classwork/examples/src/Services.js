import React from 'react';
import { Link, Outlet } from 'react-router-dom';

function Services() {
  return (
    <div>
      <link to='/services/service1'>Service 1</link>
      <link to='/services/service2'>Service 2</link>
      <link to='/services/service3'>Service 3</link>
      <Outlet/>
    </div>
  )
}

export default Services
