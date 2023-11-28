import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Homea from './Homea'
import Abouta from './Abouta'
import Servicea from './Servicea'

function router() {
  return (
    // <div>
      
    // </div>
    <BrowserRouter>
        <Link to='/homea' className='me-2 text-black'>Home</Link>
        <Link to='abouta' className='me-2 text-black'>About</Link>
        <Link to='services' className='me-2 text-black'>Services</Link>
        <Routes>
            <Route path='/homea' element={<Homea/>}></Route>
            <Route path='/abouta' element={<Abouta/>}></Route>
            <Route path='/services' element={<Servicea/>}>
                <Route path='service1' element={<Service1/>}></Route>
                <Route path='service2' element={<Service1/>}></Route>
                <Route path='service3' element={<Service1/>}></Route>
            </Route>
        </Routes>
    </BrowserRouter>
    )
}

export default router
