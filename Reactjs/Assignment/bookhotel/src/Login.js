import React, { useContext, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { loginuser } from "./App";

function Login() {

  const [email, setEmail] = useState("");
  const [pass, setPass] = useState("");
  const [userName, setuserName] = useState("");
  const navigate = useNavigate();
  const {setlogin} = useContext(loginuser)
 
  
   



  function handleSubmit(e) {

    e.preventDefault();
    fetch('http://localhost:8000/users')
      .then((res) => { return res.json() })
      .then((data)=>{

        data.map((v)=>{

          if(email != '' && pass != '')
          {
          if(v.email == email)
          {
           if(v.pass== pass)
           {
            setlogin(v.fname)
            alert("login sccess")
            navigate('/')
           }
           else if(v.pass != pass)
           {
            alert("Wrong password")
           }
          }

          else if(v.email != email)
          {
            alert("Wrong Email")
          }

         
          }

         

      })
      })


    console.log(email)
  }
  return (
    <div className="container">
      <h3>
        <Link to="/">LOGO</Link>
      </h3>
      <form onSubmit={handleSubmit}>

        <div className="form-group">
          <label >Email address</label>
          <input
            type="text"
            value={email}
            onChange={(e) => { setEmail(e.target.value) }}
            className="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="Enter email"
          />
          <small id="emailHelp" className="form-text text-muted">
            We'll never share your email with anyone else.
          </small>
        </div>


        <div className="form-group">
          <label >Password</label>
          <input
            type="text"
            value={pass}
            onChange={(e) => { setPass(e.target.value) }}
            className="form-control"
            id="exampleInputPassword1"
            placeholder="Password"
          />
        </div>


        <div className="form-group form-check">
          <input
            type="checkbox"
            className="form-check-input"
            id="exampleCheck1"
          />
          <label className="form-check-label" htmlFor="exampleCheck1">
            Check me out
          </label>
        </div>


        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </div>
  );
}

export default Login;
