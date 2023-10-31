import React from 'react'
import { useState } from 'react'

function FunctionChangeObject() {

    const [Data, setData] = useState(
        {
            "Name":"Sanjay",
            "Age":57,
            "Course":"React JS"
        }
    )

    const ChangeObject= ()=>{
        setData(
            {
                "Name":"Sanjay Tamboli",
                "Age":58,
                "Course":"Java Full Stack"
            }
        )
    }

    return (
        <div>
            Name: {Data.Name}<><br></br></>
            Age: {Data.Age}<><br></br></>
            Course: {Data.Course}
            <button onClick={ChangeObject}>Change Object Value</button>
            <input type="textbox" value={Data.Course} onChange={(val)=>setData({...Data, Course: val.target.value})}></input>
        </div>
    )
}

export default FunctionChangeObject
