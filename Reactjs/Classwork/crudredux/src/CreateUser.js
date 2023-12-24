import React, { useState } from 'react';
import { addusers } from './UserReducer';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

function CreateUser() {

    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [email,setEmail] = useState("");

    const dispatch =useDispatch();
    const navigate = useNavigate();
    const usersData =  useSelector(state => state.users);
    console.log(usersData);

    const handleSubmit = (e)=>{
        e.preventDefault();
        dispatch(addusers({id:usersData.length+ 1,name,email}));
        navigate('/');
    }

    return (
        <div className='row justify-content-center text-start'>
            <div className='col-6'>
                <form className='container' onSubmit={handleSubmit}>
                    <h2 className='mt-3'>Add User</h2>
                    <div className='col-12'>
                        <label className='form-label'>Id</label>
                        <input disabled="disabled" className='form-control'></input>
                    </div>
                    <div className='col-12'>
                        <label className='form-label'>Name</label>
                        <input value={name} onChange={(e)=>{setName(e.target.value)}} className='form-control'></input>
                    </div>
                    <div className='col-12'>
                        <label className='form-label'>Email</label>
                        <input value={email} onChange={(e)=>{setEmail(e.target.value)}} className='form-control'></input>
                    </div>
                    <div className='col-12'>
                        <button className='btn btn-info mt-3'>Save</button>
                    </div>
                </form>            
            </div>     
        </div>
    )
}

export default CreateUser
