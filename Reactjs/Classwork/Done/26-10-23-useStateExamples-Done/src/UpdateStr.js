import React, { useState } from 'react'

function UpdateStr() {

  const [greet,setGreet] = useState("Hi");

  const updateStr = ()=>{
    // setGreet("hello");
    // setGreet(greet + " Krishna")
    // setGreet(()=>(
    //   greet + " Pal"
    // ))

    setGreet((p)=>(
      p + " Dhiraj"
    ))
  }
  return (
    <div>
      <h1 onClick={updateStr}>Greeting : {greet}</h1>
    </div>
  )
}

export default UpdateStr
