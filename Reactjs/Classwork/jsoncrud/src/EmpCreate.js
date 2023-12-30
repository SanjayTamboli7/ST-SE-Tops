import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

function EmpCreate() {

    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [email,setEmail] = useState("");
    const [phone,setPhone] = useState("");
    const [active,setActive] = useState(false);
    const navigate = useNavigate();
    
    const handleClick =(e)=>{

        // We call a preventDefault on the event when submitting the form, and this will cancel the default event behavior 
        // (browser refresh) while allowing us to execute any code we write inside handleSubmit.        
        
        e.preventDefault();
        console.log(id,name,email,phone,active)

        const empData = {id,name,email,phone,active};

        fetch("http://localhost:8000/employee",{
            method: "POST",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(empData)
        })
        .then((res)=>{
            if(res)
            {
                alert("Saved successfully..!");
                navigate('/')
            }})
    }

  return (
    <div className='App'>
        <h4>Add Employee</h4>
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
                    <input value={email} onChange={(e)=>{setEmail(e.target.value)}} type='text' className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Phone</label>
                    <input value={phone} onChange={(e)=>{setPhone(e.target.value)}} type='text' className='form-control'></input>
                </div>
                <div className='col-12 mt-2'>                    
                    <input value={active} onChange={(e)=>{setActive(e.target.checked)}} type='checkbox' className='form-check-input'></input>
                   {" "} <label className='form-check-label'>Is Active</label>
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

export default EmpCreate
