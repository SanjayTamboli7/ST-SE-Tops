import React, { useState } from 'react'

function UpdateNetsedObj() {

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
        <h1>Name: {data.name}</h1>
        <h1>Age: {data.age}</h1>
        <h1 onClick={ChangeArea}>Area: {data.address.area}</h1>
      
    </div>
  )
}

export default UpdateNetsedObj
