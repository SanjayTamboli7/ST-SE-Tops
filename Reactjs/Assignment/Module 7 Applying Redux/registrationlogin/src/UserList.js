import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

function UserList() {
    const [userData,setUserData] =  useState("");
    const navigate = useNavigate();
  
    useEffect(()=>{
        fetch("http://localhost:8000/user")
        .then((res)=>{ return res.json()})
        .then((data)=>{setUserData(data)})
        .catch((e)=>{console.log(e.message)})
    })
  
    const LoadView =(id)=>{
        navigate("/user/view/"+id)
    }
  
    const LoadEdit = (id)=>{
        navigate("/user/edit/"+id)
    }
  
    const LoadDelete =(id)=>{
       if(window.confirm("Are you sure??"))
       {
        fetch("http://localhost:8000/user/"+id,{
            method: "DELETE",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(userData)
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
        <h4>User List</h4>
        <div>
            <Link to='/user/add' className='btn btn-warning m-4'>Add New (+)</Link>
            <Link to='/user/login' className='btn btn-warning m-4'>User Login</Link>
        </div>
        <table className='table'>
            <thead className='table-dark'>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Password</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
            {userData && userData.map((items)=>(
                <tr>
                    <td>{items.id}</td>
                    <td>{items.name}</td>
                    <td>{items.email}</td>
                    <td>{items.password}</td>
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
  
export default UserList
