import React, { useState } from 'react'

function UsestateEx2() {

    const [text,setText] = useState("Pal");
    const handleChange = ()=>{
        setText("Krishna")
    }

  return (
    <div>
        {text}
        <button onClick={handleChange}>Update</button>      
    </div>
  )
}

export default UsestateEx2
