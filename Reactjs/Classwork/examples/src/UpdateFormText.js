import React, { useState } from 'react'

function UpdateFormText() {

    const [text,setText] = useState("")
    const UpdateText =(e)=>{
        console.log(e.target)
        console.log(e.target.value)
        setText(e.target.value)
    }

  return (
    <div>
        <input type='text' value={text} onChange={UpdateText}/>
        <h5>text : {text}</h5>      
    </div>
  )
}

export default UpdateFormText
