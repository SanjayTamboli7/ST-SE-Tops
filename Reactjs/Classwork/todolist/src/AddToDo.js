import React, { useState } from 'react'

function AddToDo({onaddTodo}) {

  const [title,setTitle] = useState("");


  return (
    <div>

    {/* {title} */}
      <input
      value={title}
      onChange={(e)=>{setTitle(e.target.value)}}
      />
      <button onClick={()=>{
        onaddTodo(title)
      }}>Add</button>
      
    </div>
  )
}

export default AddToDo


