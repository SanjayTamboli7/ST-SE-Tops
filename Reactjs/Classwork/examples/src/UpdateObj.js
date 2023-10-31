import React, { useState } from 'react'

function UpdateObj() {

   const [data,setData] =  useState({
        name:"Bhavesh",
        age:22
    })
  return (
    <div>
        <input
        value={data.name}
        onChange={(e)=>{
            setData({
                ...data,
                name:e.target.value,
                // age:e.target.value
            })
        }}
        />
        <h5>Name : {data.name}</h5>
        <h5>Age : {data.age}</h5>
        <button onClick={(e)=>{
            setData({
                ...data,
                age:data.age + 1
            })
        }}>Update Age</button>      
    </div>
  )
}

export default UpdateObj
