import React, { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

function Register() {

  const [fname, setFname] = useState("");
  const [lanme, setLanme] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const [pass, setPass] = useState("");
  const navigate = useNavigate();
  const h3Ref = useRef();

  const CheckDuplicate = () => {
    const [userList, setUserList] = useState("");
    useEffect(() => {
      fetch("http://localhost:5000/users")
        .then((res) => { return res.json() })
        .then((data) => { setUserList(data) })
        .catch((e) => { console.log(e.message) })
    })

    {
      userList && userList.map((items) => {
        if (items.email == email) {
          alert("This user exists in the data.");
          return false;
        }
      })
    }
    return true;
  }

  function handleSubmit(e) {
    e.preventDefault();

    if (CheckDuplicate) {
      const userData = { fname, lanme, phone, email, pass }

      fetch("http://localhost:5000/users", {
        method: "POST",
        "headers": { "content-type": "application/json" },
        body: JSON.stringify(userData)
      })

        .then((res) => {
          if (res) {
            alert("Saved successfully..!");
            navigate('/login')
          }
        })
    }

    if (fname.length === 0 || lanme.length === 0 || email.length === 0 || phone.length === 0 || pass.length === 0) {
      h3Ref.current.innerHTML = "Please fill in all fields...!"
    }
    else {
      navigate('/login')
    }
  }

  return (
    <div>
      <div className="container">

        <h3 ref={h3Ref} className="text-danger">...</h3>
        <h2>Registration Form</h2>
        <form onSubmit={handleSubmit}>

          <div className="form-group">
            <label>First Name</label>
            <input
              value={fname}
              onChange={(e) => { setFname(e.target.value) }}
              type="text"
              className="form-control"
              id="exampleInputfirstname"
              name="firstname"
            />
            {fname.length === 0 && <span className="text-danger">* Enter firstname</span>}
          </div>

          <div className="form-group">
            <label>Last Name</label>
            <input
              type="text"
              value={lanme}
              onChange={(e) => { setLanme(e.target.value) }}
              className="form-control"
              id="exampleInputlastname"
              name="lastname"
            />
            {lanme.length === 0 && <span className="text-danger">* Enter lastname</span>}
          </div>

          <div className="form-group">
            <label>Phone Number</label>
            <input
              type="text"
              value={phone}
              onChange={(e) => { setPhone(e.target.value) }}
              className="form-control"
              id="exampleInputphoneno"
              name="phoneno"
            />
            {phone.length === 0 && <span className="text-danger">* Enter phone number</span>}
          </div>

          <div className="form-group">
            <label>Email address</label>
            <input
              type="email"
              value={email}
              onChange={(e) => { setEmail(e.target.value) }}
              className="form-control"
              id="exampleInputEmail1"
              aria-describedby="emailHelp"
              name="email"
            />
            {email.length === 0 && <span className="text-danger">* Enter Email Address</span>}
          </div>

          <div className="form-group">
            <label>Password</label>
            <input
              type="password"
              value={pass}
              onChange={(e) => { setPass(e.target.value) }}
              className="form-control"
              id="exampleInputPassword"
              name="password"
            />
            {pass.length === 0 && <span className="text-danger">* Enter Password</span>}
          </div>

          <button type="submit" className="btn btn-primary" name="create">
            Sign up
          </button>
        </form>
      </div>
    </div>
  );
}

export default Register;