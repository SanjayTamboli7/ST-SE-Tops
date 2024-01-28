import React from 'react'
import { Link } from 'react-router-dom'

function Header() {

  // const [loginFlag, setloginFlag] = useState(false);
  
  return (
    <div>
      <header>
        <div className='logo'>Logo</div>
        <div>
          <Link to="/register">Register</Link>     
          <span>      </span>     
          {/* {loginFlag ? alert("Login"): alert("Logout")} */}
          <Link to="/login">Login</Link>
          {/* {setloginFlag(true)}; */}
        </div>
      </header>

      <nav>
        <ul className="list-unstyled">
          <li style={{display: "inline-block", marginRight: "10px"}}>
            <Link to="/">Home</Link>
          </li>
          <li style={{display: "inline-block", marginRight: "10px"}}>
            <Link to="/about">About</Link>
          </li>
          <li style={{display: "inline-block", marginRight: "10px"}}>
            <Link to="/service">Service</Link>
          </li>
          <li style={{display: "inline-block", marginRight: "10px"}}>
            <Link to="/contact">Contact</Link>
          </li>
          <li style={{display: "inline-block", marginRight: "10px"}}>
            <Link to="/blog">Blog</Link>
          </li>
        </ul>
      </nav>
    </div>
  )
}

export default Header


