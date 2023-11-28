import React from "react";

class ClassPropEx extends React.Component
{

    Test()
    {
        return true
        alert("Alert CLass")
    }

    render()
    {
        return(
            <>
            <h1 onClick={this.Test}>Class Props</h1>
                {this.props.name}
            </>
        )
    }
}

export default ClassPropEx;