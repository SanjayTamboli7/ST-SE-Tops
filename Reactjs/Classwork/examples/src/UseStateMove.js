import React,{useState} from 'react'

function UseState_Move() {
    const [pos,setPos] = useState({x:0,y:0})

    const handleMove = (e)=>{
      setPos({
        x:e.clientX,
        y:e.clientY          
      })  
      // console.log(e)
      // console.log(e.clientX)
    }
  
    window.addEventListener("mousemove",handleMove)     
  
    return (      
      <div style={{
        height:20,
        width:"20px",
        background:"blue",
        borderRadius:"50%",
        // marginTop:`${pos.x}px`,
        // marginLeft:`${pos.y}px`
        transform:`translate(${pos.x}px,${pos.y}px)`,
        position:"absolute",
        top:-10,
        left:-10  
      }}>       
      </div>
    )
}

export default UseState_Move
