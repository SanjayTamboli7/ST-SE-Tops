import React, { useEffect, useState } from 'react'

function UseEffecthook1() {

    const [x,setX] = useState({n1:1,n2:12})

    useEffect(()=>{

    //   const h =   (e)=>{
    //         console.log(e)
    //     }

      //  let x =  document.getElementById('t')
    //    x.addEventListener("click",h)

    let val = x;
    console.log(val)

    },[x])
  return (
    <div>
        <h1 id='t'>Hello</h1>

    </div>
  )
}

export default UseEffecthook1

