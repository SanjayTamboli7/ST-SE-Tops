import React, { useState } from 'react'

function UpdateFormChkbox() {

    const [bool,setBool] = useState(false)

    // const UpdateBool = ()=>{
    //     setBool(true)
    // }

  return (
    <div>
        {/* <input 
        type='checkbox'
        onChange={UpdateBool}
        /> */}

        <input 
        type='checkbox'
        onChange={()=>{
            setBool(true)
        }}
        />      
        You checked this

        <h1>
        {(bool)? "T": "F"}
        </h1>
      
    </div>
  )
}

export default UpdateFormChkbox
