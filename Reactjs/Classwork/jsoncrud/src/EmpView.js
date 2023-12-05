import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

function EmpView() {
    const {empId} = useParams();
    const [empData,setEmpData] = useState("");

    useEffect(()=>{

        fetch("http://localhost:8000/employee/"+empId)
        .then((res)=>{ return res.json()})
        .then((data)=>{
            setEmpData(data)
        })

    })
  return (
    <div className='App container'>
        <h4>View Details</h4>
        <table className='table' >
          <thead className='table-dark'>
          <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Email</td>
                <td>Phone</td>
                <td>Active User</td>                
            </tr>
          </thead>

           <tbody>
           <tr>
                <td>{empData.id}</td>
                <td>{empData.name}</td>
                <td>{empData.email}</td>
                <td>{empData.phone}</td>
                <td>{(empData.active)? "Yes" : "No"}</td>
            </tr>
            </tbody>            
        </table>
    </div>
  )
}

export default EmpView
