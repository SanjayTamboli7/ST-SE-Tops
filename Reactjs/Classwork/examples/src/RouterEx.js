import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Homea from './Homea';
import Abouta from './Abouta';
// import Servicea from './Servicea'
import Services from './Services';
import Service1 from './Service1';
import Service2 from './Service2';
import Service3 from './Service3';

function RouterEx() {
  return (
        <div>
            <BrowserRouter>
            <Link to='/home' className='me-2 text-black'>Home</Link>
            <Link to='/about' className='me-2'>About</Link>
            <Link to='/services'>Services</Link>
            <Routes>
                <Route path='/home' element={<Homea/>}></Route>
                <Route path='/about' element={<Abouta/>}></Route>
                <Route path="/services" element={<Services/>}>
                    <Route path="/services/services1" element={<Service1/>}></Route>
                    <Route path="/services/services2" element={<Service2/>}></Route>
                    <Route path="/services/services3" element={<Service3/>}></Route>
                </Route>      
            </Routes>
            </BrowserRouter>
        </div>
    )
}

export default RouterEx
