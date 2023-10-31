import React, { useState } from 'react'

function UpdateNestedObj1() {
    const [data,setData] = useState({
        name:"Himanshu",
        age:12,
        address: {
            city:{
            area:"CG",
            Pin:380008
            }
        }
    })
    const ChangeArea = ()=>{
        setData({
            ...data,
            name:"hi",
            address:{
                ...data.address,
                city:{...data.address.city,
                Pin:3123}                           
            }
        })
    }
  return (
    <div>
        <h5>Name: {data.name}</h5>
        <h5>Age: {data.age}</h5>
        <h5>Pin: {data.address.city.Pin}</h5>
        <h5 onClick={ChangeArea}>Area: {data.address.area}</h5>     
        <input type='text' value={data.name} onChange={ChangeArea}/>         
    </div>
  )
  
}

export default UpdateNestedObj1
