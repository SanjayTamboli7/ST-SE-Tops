import React from 'react'
class StateEx extends React.Component 
{
    constructor()
    {
        super();
        this.state = { count : 1}
    }

    // inc = ()=>{        
    //     this.setState({count:20})
    // }
    // inc = ()=>{        
    //     this.setState({count:this.state.count+2})
    // }
    // inc = ()=>{        
    //     this.setState(()=>( {count:this.state.count+ 1} )
    // }
    inc = ()=>{        
        this.setState((prev)=>( {count:prev.count+ 1} ))
    }

    render(){
        return(
            <>
               <h1> {this.state.count} </h1>
               <button onClick={this.inc}>Increment</button>
            </>
        )
    }
}

export default StateEx
