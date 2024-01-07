import React, { useState ,useEffect} from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';

function UserEdit() {
    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [email,setEmail] = useState("");
    const [password,setPassword] = useState("");

    const navigate = useNavigate();
    const {userId} = useParams();

    useEffect(()=>{

        fetch("http://localhost:8000/user/"+userId)
        .then((res)=>{ return res.json()})
        .then((data)=>{
            setId(data.id)
            setName(data.name)
            setEmail(data.email)
            setPassword(data.password)
        })},[])

    const handleClick =(e)=>{
        e.preventDefault();
        console.log(id,name,email,password)
        const userData = {id,name,email,password};
        fetch("http://localhost:8000/user/"+userId,{
            method: "PUT",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(userData)
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
        <h4>Edit User</h4>
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
                    <input value={email} onChange={(e)=>{setEmail(e.target.value)}} type='email' className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Password</label>
                    <input value={password} onChange={(e)=>{setPassword(e.target.value)}} type='password' className='form-control'></input>
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

export default UserEdit
