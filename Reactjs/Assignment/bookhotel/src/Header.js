import React, { useContext } from 'react'
import { Link } from 'react-router-dom'
import { loginuser } from './App'

function Header() {

  // const [loginFlag, setloginFlag] = useState(false);
  
  const {login,setlogin} = useContext(loginuser)

  return (
    <div>
      <header>
        <div className='logo'>Logo</div>
        <div>
          {login ?
          <button onClick={()=>{setlogin('')}}>logout</button>     
          
          : <div>
          <Link to="/register">Register</Link>     
          <span>      </span>     
          <Link to="/login">Login</Link></div>}
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


