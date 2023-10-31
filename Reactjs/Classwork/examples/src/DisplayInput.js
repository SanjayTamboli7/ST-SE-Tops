import React, { useState } from 'react'

function DisplayInput() {

  const [x,setX] = useState("hello");
  const handleChange = ()=>{
    setX("s,slkdfj")
  }

  return (
    <div>       
        <input type="text" value={x} onChange={(e)=>{setX(e.target.value)}}/>
        <p>You entered {x}</p>
        <button onClick={handleChange}>Update</button>      
    </div>
  )
}

export default DisplayInput