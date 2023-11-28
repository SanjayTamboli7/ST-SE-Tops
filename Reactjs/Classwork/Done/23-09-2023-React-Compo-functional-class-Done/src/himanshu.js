import React from "react";


function Test1()
{
    const y =20;
    return(
        <>
            <h3>TEST1</h3>
            <h4>{y}</h4>
        </>
    )
}

class Test123 extends React.Component
{

    render()
    {
      
        return(
            <>
             <h2>Class Component</h2>
             <Test1/>
                
            </>
        )
    }
}
export default Test123;