import React from 'react'

class ClsChangeString extends React.Component {
    constructor()
    {
        super();
        this.state ={c:"hi"}     
    }

    ChangeString = ()=> {
        this.setState({c:"Nexon"})
    }

    render()
    {
        return (
            <div>
                {this.state.c}
                <button onClick={this.ChangeString}>Class Change String</button>
            </div>
        )
    }
}

export default ClsChangeString 
