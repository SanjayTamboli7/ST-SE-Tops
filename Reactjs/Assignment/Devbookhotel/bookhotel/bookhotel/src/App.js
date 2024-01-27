import './App.css';
import Destination from './Destination';
import ShowHotelImages from './ShowHotelImages';
import ShowHotels from './ShowHotels';
import { Link } from 'react-router-dom'


function App() {
  return (
    <div className="App">

      <div className="ClsHeader">
        <div className="row1">
          <div className="r1Col1"></div>
          <div className="r1Col1">Sign up</div>
          <div className="r1Col1">Login</div>
          {/* <div className="r1Col1"><Link to="/register">Register</Link></div>
          <div className="r1Col1"><Link to="/login">Login</Link></div> */}
            {/* <div>
                <Link to="/register">Register</Link>
                <Link to="/login">Login</Link>
            </div> */}
        </div>
      </div>

      <Destination/>
      <ShowHotels/>
      <ShowHotelImages/>
      This is the main project.
    </div>
  );
}

export default App;

// https://github.com/kaushiksheel/Hotel-Booking-WebApp/blob/main/src/components/Navbar.jsx