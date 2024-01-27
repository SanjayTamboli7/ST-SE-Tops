// import logo from './logo.svg';
import './App.css';
import Home from './Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import About from './About';
import Services from './Services';
import Contact from './Contact';
import BLog from './BLog';
import Register from './Register';
import Login from './Login';
import ShowHotels from './ShowHotels';
import Destination from './Destination';
import ShowHotelImages from './ShowHotelImages';
import { createContext, useState } from 'react';
import Error from './Error';


export const Hoteldata = createContext()
export const loginuser = createContext()



function App() {
 const [hoteldatas,showhoteldatas] = useState('')
 const [login,setlogin] = useState('')

  console.log(login)

  return (
    <div className="App">
      <BrowserRouter>
      <Hoteldata.Provider value={{hoteldatas,showhoteldatas}}>
 <loginuser.Provider value={{login,setlogin}}>
        <Routes>
          <Route path='/' element={<Home />}> </Route>
          <Route path='/register' element={<Register />}> </Route>
          <Route path='/login' element={<Login />}> </Route>

          <Route path='/about' element={<About />}> </Route>
          <Route path='/service' element={<Services />}> </Route>
          <Route path='/destination' element={<Destination/>}> </Route>
          <Route path='/contact' element={<Contact />}> </Route>
          <Route path='/ShowHotels' element={<ShowHotels/>}> </Route>
          <Route path='/blog' element={<BLog />}> </Route>
          <Route path='/ShowHotelImages' element={<ShowHotelImages/>}> </Route>
          <Route path='*' element={<Error/>}> </Route>


        </Routes>
        </loginuser.Provider>
        </Hoteldata.Provider>

      </BrowserRouter>

    </div>
  );
}

export default App;

// npm install react-router-dom@6  bootstrap
// npm i -g json-server
// Json-server --watch users.json --port 5000
