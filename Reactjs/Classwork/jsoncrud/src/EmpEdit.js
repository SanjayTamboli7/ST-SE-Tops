import React, { useState ,useEffect} from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';

function EmpEdit() {

    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [email,setEmail] = useState("");
    const [phone,setPhone] = useState("");
    const [active,setActive] = useState(false);

    const navigate = useNavigate();
    const {empId} = useParams();

    useEffect(()=>{

        fetch("http://localhost:8000/employee/"+empId)
        .then((res)=>{ return res.json()})
        .then((data)=>{
            setId(data.id)
            setName(data.name)
            setEmail(data.email)
            setPhone(data.phone)
        })},[])

    const handleClick =(e)=>{
        e.preventDefault();
        console.log(id,name,email,phone,active)
        const empData = {id,name,email,phone,active};
        fetch("http://localhost:8000/employee/"+empId,{
            method: "PUT",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(empData)
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
                  <Link to="/" className='btn btn-info'>Back</Link>
                </div>
            </form>
        </div>     
    </div>
  )
}

export default EmpEdit
