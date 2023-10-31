import React from 'react'
import { useState } from 'react';

function FunctionChangeNo() {

    const [Data, SetData] = useState(0);

    const Increase = ()=> {
        SetData(Data+1);
    }
    return (
        <div>
            Variable Value = {Data}
            <button onClick={Increase}>Increment</button>
        </div>
  )
}

export default FunctionChangeNo
