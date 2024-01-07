import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

function UserView() {
    const {userId} = useParams();
    const [userData,setUserData] = useState("");

    useEffect(()=>{

        fetch("http://localhost:8000/user/"+userId)
        .then((res)=>{ return res.json()})
        .then((data)=>{
            setUserData(data)
        })

    })
  return (
    <div className='App container'>
        <h4>View User</h4>
        <table className='table' >
          <thead className='table-dark'>
          <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Email</td>
                <td>Password</td>
            </tr>
          </thead>

           <tbody>
           <tr>
                <td>{userData.id}</td>
                <td>{userData.name}</td>
                <td>{userData.email}</td>
                <td>{userData.password}</td>
            </tr>
            </tbody>            
        </table>
    </div>
  )
}

export default UserView
