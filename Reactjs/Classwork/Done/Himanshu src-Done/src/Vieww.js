import React, { useState } from 'react';
import { updateUsers } from './UserReducer';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';

function Vieww() {

    const {userid} = useParams();
    console.log(userid);

    const usersData =  useSelector(state => state.users)
    console.log(usersData);

    const existingUSer = usersData.filter(user=>user.id == userid)

//    console.log(existingUSer[0])

   const {id,name,email} = existingUSer[0];

  return (
    <div>
    id =  {id} <br/>
    name =  {name} <br/>
    email =  {email}
    </div>
  )
}

export default Vieww
