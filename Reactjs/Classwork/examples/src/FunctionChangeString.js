import React from 'react'
import { useState } from 'react';

function FunctionChangeString() {

    const [Name, ChangeName] = useState("JavaScript");

    const ChangeString = ()=> {
        ChangeName("React.js")
    }
    return (
        <div>
            Value = {Name}
            <button onClick={ChangeString}>Change String</button>
        </div>
    )
}

export default FunctionChangeString
