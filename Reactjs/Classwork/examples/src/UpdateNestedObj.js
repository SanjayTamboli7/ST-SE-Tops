import React, { useState } from 'react'

function UpdateNestedObj() {
    const [data,setData] = useState({
        name:"Himanshu",
        age:12,
        address: {
            city:"Ahmedabad",
            area:"CG"
        }
    })
    const ChangeArea = ()=>{
        setData({
            ...data,
            name:"hi",
            address:{
                ...data.address,
                area:"SG",               
            }
        })
    }
  return (
    <div>
        <h5>Name: {data.name}</h5>
        <h5>Age: {data.age}</h5>
        <h5 onClick={ChangeArea}>Area: {data.address.area}</h5>
      
    </div>
  )
}

export default UpdateNestedObj
