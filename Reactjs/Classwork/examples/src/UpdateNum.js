import React, { useState } from 'react'

function UpdateNum() {
    // const [num,setNum] = useState(0);
    const [num, setNum] = useState(0)
    const UpdateNum = ()=>{
        // setNum(2)
        // setNum(num+1)
        // setNum(()=>(
        //    num+1
        // ))
        setNum((prev)=>(
            prev+1
        ))        
    }

  return (
    <div>
        <h5 onClick={UpdateNum}>Number : {num}</h5>      
    </div>
  )
}

export default UpdateNum
