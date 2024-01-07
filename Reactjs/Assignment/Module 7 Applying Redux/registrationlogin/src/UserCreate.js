import React from 'react'
import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

function UserCreate() {
    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [email,setEmail] = useState("");
    const [password,setPassword] = useState("");
  
    const navigate = useNavigate();
  
    const handleClick =(e)=>{
  
        // We call a preventDefault on the event when submitting the form, and this will cancel the default event behavior 
        // (browser refresh) while allowing us to execute any code we write inside handleSubmit.        
        
        e.preventDefault();
        console.log(id,name,email,password)
  
        const UserData = {id,name,email,password};
  
        fetch("http://localhost:8000/user",{
            method: "POST",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(UserData)
        })
        .then((res)=>{
            if(res)
            {
                alert("Saved successfully..!");
                navigate('/');
            }})
    }
  
  return (
    <div className='App'>
        <h4>Add User</h4>
        <div className='row justify-content-center text-start'>
  
            <form className='col-6' onSubmit={handleClick}>
                <div className='col-12'>
                    <label className='form-label'>Id</label>
                    <input type='text' disabled="disabled" className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Name</label>
                    <input value={name} onChange={(e)=>{setName(e.target.value)}} type='text' className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Email</label>
                    <input value={email} onChange={(e)=>{setEmail(e.target.value)}} type='email' className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Password</label>
                    <input value={password} onChange={(e)=>{setPassword(e.target.value)}} type='password' className='form-control'></input>
                </div>
                <div className='col-12 mt-3' >
                  <button type='submit' className='btn btn-primary me-2'>Save</button>
                  <Link to="/" className='btn btn-info '>Back</Link>
                </div>
            </form>
        </div>     
    </div>
  )
  }

export default UserCreate
