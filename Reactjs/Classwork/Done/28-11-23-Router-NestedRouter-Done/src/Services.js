import React from 'react'
import { Link, Outlet } from 'react-router-dom'

function Services() {
  return (
    <div>
      <Link to='/services/services1'>services 1</Link>
      <Link to='/services/services2'>Services 2</Link>
      <Link to='/services/services3'>services2 3</Link>
      <Outlet/>
    </div>
  )
}

export default Services
