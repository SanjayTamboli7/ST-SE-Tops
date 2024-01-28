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

// import ShowHotels from './ShowHotels';
// import Destination from './Destination';
// import ShowHotelImages from './ShowHotelImages';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home />}> </Route>
          <Route path='/register' element={<Register />}> </Route>
          <Route path='/login' element={<Login />}> </Route>

          <Route path='/about' element={<About />}> </Route>
          <Route path='/service' element={<Services />}> </Route>
          {/* <Route path='/service' element={<Destination/>}> </Route> */}
          <Route path='/contact' element={<Contact />}> </Route>
          {/* <Route path='/contact' element={<ShowHotels/>}> </Route> */}
          <Route path='/blog' element={<BLog />}> </Route>
          {/* <Route path='/blog' element={<ShowHotelImages/>}> </Route> */}

        </Routes>
      </BrowserRouter>

    </div>
  );
}

export default App;

// npm install react-router-dom@6  bootstrap
// npm i -g json-server
// Json-server --watch users.json --port 5000
