import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import CustomHook from './CustomHook';
import Home from './Home';
import About from './About';
import Services from './Services';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import Service1 from './Service1';
import Service2 from './Service2';
import Service3 from './Service3';

function App() {
 
 
  return (

    // <div className='App'> Browserrouter
    //  <ul> Routes
    //   <li><a>Home</a></li> Route
    //   <li><a>About</a></li>Route
    //   <li><a>Services</a> <Link></li>Route
    //  </ul>
    // </div>

<div className='App'>
  <BrowserRouter>
  <Link to='/home' className='me-2 text-black'>Home</Link>
  <Link to='/about' className='me-2'>About</Link>
  <Link to='/services'>Services</Link>
  <Routes>
    <Route path='/home' element={<Home/>}></Route>
    <Route path='/about' element={<About/>}></Route>
    <Route path="/services" element={<Services/>}>
        <Route path="/services/services1" element={<Service1/>}></Route>
        <Route path="/services/services2" element={<Service2/>}></Route>
        <Route path="/services/services3" element={<Service3/>}></Route>
    </Route>      
  </Routes>
  </BrowserRouter>

      {/* <Home/>
      <About/>
      <Services/> */}

</div>
  );
}

export default App;
