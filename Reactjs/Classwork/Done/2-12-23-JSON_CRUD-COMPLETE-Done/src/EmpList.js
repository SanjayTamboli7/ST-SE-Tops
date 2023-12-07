import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

function EmpList() {

    const [empData,setEmpData] =  useState("");
    const navigate = useNavigate();

    useEffect(()=>{
        fetch("http://localhost:8000/employee")
        .then((res)=>{ return res.json()})
        .then((data)=>{setEmpData(data)})
        .catch((e)=>{console.log(e.message)})
    })

    const LoadView =(id)=>{
        navigate("/emp/view/"+id)
    }

    const LoadEdit = (id)=>{
        navigate("/emp/edit/"+id)
    }

    const LoadDelete =(id)=>{
       if(window.confirm("Are you sure??"))
       {
        fetch("http://localhost:8000/employee/"+id,{
            method: "DELETE",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(empData)
        })
        .then((res)=>{
            if(res)
            {
                alert("Deleted successfully..!");
                navigate('/')
            }})
       
        window.location.reload();
       }
    }

  return (
    <div className='App container'>        
        <h4>Employee List</h4>
        <div>
            <Link to='/emp/add' className='btn btn-warning m-4'>Add New (+)</Link>
        </div>
        <table className='table'>
            <thead className='table-dark'>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Phone</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
            {empData &&  empData.map((items)=>(
                <tr>
                    <td>{items.id}</td>
                    <td>{items.name}</td>
                    <td>{items.email}</td>
                    <td>{items.phone}</td>
                    <td>
                        <button onClick={()=>{LoadEdit(items.id)}} className='btn btn-success me-2'>Edit</button>
                        <button onClick={()=>{LoadDelete(items.id)}} className='btn btn-danger me-2'>Delete</button>
                        <button onClick={()=>{LoadView(items.id)}} className='btn btn-info me-2'>View</button>
                    </td>
                </tr>
            ))}          
            </tbody>
        </table>    
    </div>
  )
}

export default EmpList
