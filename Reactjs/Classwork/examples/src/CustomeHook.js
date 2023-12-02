import React, { useState, useEffect } from 'react' ;

function CustomeHook() {

    useEffect(()=>{
        const handleMove = (e)=>{
            setPos({
              x:e.clientX,
              y:e.clientY          
            })  
            // console.log(e)
            // console.log(e.clientX)
          }        
          window.addEventListener("mousemove",handleMove)         
    })
  
  return (
    <div>
      This is custome hook example
    </div>
  )
}

export default CustomeHook
