import React, {useEffect} from 'react'

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
      
    </div>
  )
}

export default CustomeHook
