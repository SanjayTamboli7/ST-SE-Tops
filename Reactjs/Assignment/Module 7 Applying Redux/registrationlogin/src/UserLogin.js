import React from 'react'
import { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

function UserLogin() {
    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [email,setEmail] = useState("");
    const [password,setPassword] = useState("");
    const [userData,setUserData] = useState("");
  
    const navigate = useNavigate();
  
    const handleClick =(e)=>{
  
        // We call a preventDefault on the event when submitting the form, and this will cancel the default event behavior 
        // (browser refresh) while allowing us to execute any code we write inside handleSubmit.        
        
        e.preventDefault();
        console.log(id,name,email,password);
        navigate('/')

        // useEffect(()=>{
        //     fetch("http://localhost:8000/user")
        //     .then((res)=>{ return res.json()})
        //     .then((data)=>{setUserData(data)})
        //     .catch((e)=>{console.log(e.message)})
        // })            
        }
  
  return (
    <div className='App'>
        <h4>User Login</h4>
        <div className='row justify-content-center text-start'>
  
            <form className='col-6' onSubmit={handleClick}>
                <div className='col-12'>
                    <label className='form-label'>Email</label>
                    <input value={email} onChange={(e)=>{setEmail(e.target.value)}} type='email' className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Password</label>
                    <input value={password} onChange={(e)=>{setPassword(e.target.value)}} type='password' className='form-control'></input>
                </div>
                <div className='col-12 mt-3' >
                  <button type='submit' className='btn btn-primary me-2'>Login</button>
                  <Link to="/" className='btn btn-info '>Back</Link>
                </div>
            </form>
        </div>     
    </div>
  )
}

export default UserLogin
