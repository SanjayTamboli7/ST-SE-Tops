import React, { useState } from 'react'

function UpdateFormChkbox() {

    const [bool,setBool] = useState(false)

    // const UpdateBool = ()=>{
    //     setBool(true)
    // }

  return (
    <div>
        {/* <input type='checkbox' onChange={UpdateBool}/> */}
        <input type='checkbox' onChange={(e)=>{setBool(e.target.checked)}}/>      
        You checked this
        <h5> {(bool)? "T" : "F"}</h5>      
    </div>
  )
}

export default UpdateFormChkbox
