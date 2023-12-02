import React, { useState } from 'react';
import CustomHook from './CustomHook';

function CustomeHookP() {
    const [position,setPosition] = useState({x:0,y:0});  

    const handleMove = (e)=>{
           console.log(e)
           setPosition({
            //  x:e.pageX,
            x:e.ClientX,
            y:e.clientY
           })
         }
 
   CustomHook("mousemove",handleMove)
  
   return (
     <div style={{
       height:20,
       width:20,
       background:"blue",
       borderRadius:"50%",
       transform:`translate(${position.x}px,${position.y}px)`
     }}>
       
     </div>
   );
 }

export default CustomeHookP
