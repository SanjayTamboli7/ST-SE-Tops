import React, { useState } from 'react'

function UsestateEx1() {

  const [x,setX] = useState(1);
  const handleChange = ()=>{
        setX(2)
    }

  return (
    <div>
        <h5>{x}</h5>
        <button onClick={handleChange}>Set To 2</button>
        <button onClick={()=>{setX(x+1)}}>Increment</button>
        <button onClick={()=>{setX(x-1)}}>Decrement</button>      
    </div>
  )
}

export default UsestateEx1
