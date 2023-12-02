import React, { useEffect } from 'react'

function CustomHook(eventType,functionName) {

    useEffect(()=>{
       
        window.addEventListener(eventType,functionName);
      },[eventType,functionName])
  return (
    <div>
      
    </div>
  )
}

export default CustomHook
