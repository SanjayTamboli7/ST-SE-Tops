import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.css"
import { useEffect } from 'react';
import { useState } from 'react';

function App() {

  const [empData,setEmpdata] = useState("")


  useEffect(()=>{
    fetch("http://localhost:8000/employee")
    .then((res)=>{return res.json()})
    .then((data)=>{
      console.log(data);
      setEmpdata(data)

    })
    .catch((err)=>{console.log(err.message)})
  })


  return (
    <div className="App">
     
    <div className='container'>

<h3 className='text-center'>Employee Details</h3>

<div>
    <button className='btn btn-warning m-2'>Add New (+)</button>
</div>
    <table className='table'>
      <thead className='table-dark'>
        <tr>
          <td>ID</td>
          <td>Name</td>
          <td>Email</td>
          <td>Phone</td>
          <td>Action</td>
        </tr>
      </thead>

      <tbody>

        {
          empData.map((item)=>(
            // console.log(item)
            <tr>
            <td>{item.id}</td>
            <td>{item.name}</td>
            <td>{item.email}</td>
            <td>{item.phone}</td>
            <td>
              <button className='btn btn-success me-2'>Edit</button>
              <button className='btn btn-danger me-2'>Delete</button>
              <button className='btn btn-info'>View</button>
            </td>
          </tr>
          ))

        }
       
      </tbody>
    </table>


    </div>
    
    </div>
  );
}

export default App;
