// import logo from './logo.svg';
import './App.css';
import Destination from './Destination';
import ShowHotels from './ShowHotels';

function App() {
  return (
    <div className="App">

      <div className="ClsHeader">
        <div className="row1">
          <div className="r1Col1"></div>
          <div className="r1Col1">Sign up</div>
          <div className="r1Col1">Login</div>
        </div>
      </div>
      <Destination/>
      <ShowHotels/>
      
      This is the main project.



      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
    </div>
  );
}

export default App;

// https://github.com/kaushiksheel/Hotel-Booking-WebApp/blob/main/src/components/Navbar.jsx