import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function Login() {

  const [email, setEmail] = useState("");
  const [userName, setuserName] = useState("");
  const navigate = useNavigate();

  function handleSubmit(e) {
    e.preventDefault();
    fetch('http://localhost:5000/users')
      .then((res) => { return res.json() })
      .then((data) => {

        // console.log(data)
        data.map((v)=>{
            console.log(v.email)
            if(v.email === email)
              {
                setuserName(v.fname + " " + v.lname);
                navigate('/');
              }
        })

        navigate('/')
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
            type="email"
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
            type="password"
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
