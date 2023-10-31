import React, { useState } from 'react'

function UseStateNo() {
    const [x,setX] = useState(1);
    const handleChange = ()=>{
          setX(2)
      }
  
    return (
      <div>
          {x}
          <button onClick={handleChange}>Fix Increase</button>
          <button onClick={()=>{setX(x+1)}}>Increment</button>
          <button onClick={()=>{setX(x-1)}}>Decrement</button>      
      </div>
    )
}

export default UseStateNo
