import React from 'react'

class ClsChangeArray extends React.Component {
    constructor()
    {
        super();
        this.state ={c:[1, "Two", 3, "Four"]}     
    }

    ChangeArray = ()=> {
        this.setState({c:[10, "Twenty", 30, "Forty"]})
    }

    render()
    {
        return (
            <div>
                {this.state.c}
                <button onClick={this.ChangeArray}>Class Change Object</button>
            </div>
        )
    }
}

export default ClsChangeArray 
