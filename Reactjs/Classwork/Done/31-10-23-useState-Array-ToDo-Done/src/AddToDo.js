import React, { useState } from 'react'

function AddToDo({onAddTodo}) {

    const [title,setTitle] = useState("");

  return (
    <div>

        <label>
            <input
            type='text'
            value={title}
            onChange={(e)=>{setTitle(e.target.value)}}
            />
        </label>

        <label>
           <button onClick={()=>{
            onAddTodo(title)
           }}>Add</button>
        </label>
      
    </div>
  )
}

export default AddToDo
