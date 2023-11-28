import React, { useState } from 'react'

function SetPlusMinus() {
    const [x,setX] = useState(0);
    const handleChange = ()=>{
          setX(0)
      }
  
    return (
      <div>
            <h4 style={{color: "yellow", backgroundColor: "green", textAlign: "center"}}>React Web</h4>
            <table>
                <tr><td colSpan={3} style={{textAlign: "center"}}>{x}</td></tr>
                <tr><td><button onClick={()=>{setX(x-1)}}>Decrement</button>  </td><td></td><td><button onClick={()=>{setX(x+1)}}>Increment</button></td></tr>
                <tr><td></td><td><button onClick={handleChange}>Reset</button></td><td></td></tr>
            </table>
      </div>
    )
}

export default SetPlusMinus
