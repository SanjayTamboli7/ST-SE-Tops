import React, { useState } from 'react';
import { addusers } from './UserReducer';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

function CreateUser() {

    // useState is React Hook that allows you to add state to a functional component. It returns an array with two values: 
    // the current state and a function to update it. The Hook takes an initial state value as an argument and returns an updated 
    // state value whenever the setter function is called.

    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [email,setEmail] = useState("");

    // The useDispatch is yet another hook in redux which is equivalent to the mapDispatchToProps argument in the connect() 
    // higher-order function. It allows you to send or dispatch an action to the redux store by giving the action as an 
    // argument to the dispatch variable.

    const dispatch = useDispatch();

    // The useNavigate hook is a powerful and intuitive way to navigate between pages in your React application. It simplifies 
    // the process of handling URL changes and provides a consistent API for navigating between pages.
    
    const navigate = useNavigate();

    // useSelector() ​Allows you to extract data from the Redux store state for use in this component, using a selector function. 
    // The selector function should be pure since it is potentially executed multiple times and at arbitrary points in time.

    const usersData =  useSelector(state => state.users)
    console.log(usersData);

    // Calling preventDefault() during any stage of event flow cancels the event, meaning that any default action normally taken 
    // by the implementation as a result of the event will not occur.

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
