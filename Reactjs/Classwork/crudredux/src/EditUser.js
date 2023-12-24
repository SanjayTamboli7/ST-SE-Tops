import React, { useState } from 'react';
import { updateUsers } from './UserReducer';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';


function EditUser() {

    const {userid} = useParams();
    console.log(userid);

    const usersData =  useSelector(state => state.users)
    console.log(usersData);

    const existingUSer = usersData.filter(user=>user.id == userid)

//    console.log(existingUSer[0])

   const {name,email} = existingUSer[0];

//    console.log(name);

    // arr =[1,2,3]
    // const [a,b] = arr



    const [id,setId] = useState("");
    const [uname,setUname] = useState(name);
    const [uemail,setUemail] = useState(email);

    const dispatch =useDispatch();
    const navigate = useNavigate();
   

    const handleSubmit = (e)=>{
        e.preventDefault();
     
        dispatch(updateUsers({id:userid,name:uname,email:uemail}));
        navigate('/')

    }
  return (
    <div className='row justify-content-center text-start'>
    <div className='col-6'>

        <form className='container' onSubmit={handleSubmit}>

            <h2 className='mt-3'>Edit User</h2>

            <div className='col-12'>
                <label className='form-label'>Id</label>
                <input  disabled="disabled" className='form-control'></input>
            </div>

            <div className='col-12'>
                <label className='form-label'>Name</label>
                <input value={uname} onChange={(e)=>{setUname(e.target.value)}}  className='form-control'></input>
            </div>


            <div className='col-12'>
                <label className='form-label'>Email</label>
                <input value={uemail}  onChange={(e)=>{setUemail(e.target.value)}} className='form-control'></input>
            </div>

            <div className='col-12'>
                <button className='btn btn-info mt-3'>Save</button>
            </div>

        </form>
        
    </div>
 
</div>
  )
}

export default EditUser