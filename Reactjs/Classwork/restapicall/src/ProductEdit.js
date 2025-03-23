// import React, { useState ,useEffect} from 'react'
// import { Link, useNavigate, useParams } from 'react-router-dom';

import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { Link, useNavigate } from 'react-router-dom';

export default function ProductEdit() {

    const { Id } = useParams();
    console.log("In Product Edit : " + Id );
    let prodId = Id;
    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [price,setPrice] = useState("");

    const navigate = useNavigate();

    useEffect(()=>{
        fetch("http://localhost:8080/products/" + prodId, { method: "GET" })
        .then((res)=>{ return res.json()})
        .then((data)=>{
            setId(data.id)
            setName(data.name)
            setPrice(data.price)
        })}, [prodId])

    const handleClick =(e)=>{
        e.preventDefault();
        console.log(id,name,price)
        const prodData = {id,name,price};
        fetch("http://localhost:8080/products/"+prodId,{
            method: "PUT",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(prodData)
        })
        .then((res)=>{
            if(res)
            {
                alert("Updated successfully..!");
                navigate('/')
            }
        }
        )
    }

  return (
    <div className='App'>
        <h4>Edit Employee</h4>
        <div className='row justify-content-center text-start'>
            <form className='col-6' onSubmit={handleClick}>
                <div className='col-12'>
                    <label className='form-label'>Id</label>
                    <input value={id} type='text' disabled="disabled" className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Name</label>
                    <input value={name} onChange={(e)=>{setName(e.target.value)}} type='text' className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Phone</label>
                    <input value={price} onChange={(e)=>{setPrice(e.target.value)}} type='text' className='form-control'></input>
                </div>
                <div className='col-12 mt-3' >
                  <button type='submit' className='btn btn-primary me-2'>Save</button>
                  <Link to="/" className='btn btn-info'>Back</Link>
                </div>
            </form>
        </div>     
    </div>
  )
}
