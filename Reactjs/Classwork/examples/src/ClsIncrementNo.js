import React from 'react'

class ClsIncrementNo extends React.Component {
    constructor()
    {
        super();
        this.state = {count:1}        
    }

    Increment = ()=> {
        this.setState({count:this.state.count+1})
    }

    render()
    {
        return (
            <div>
                {this.state.count}
                <button onClick={this.Increment}>Class Increment</button>
            </div>
        )
    }
}

export default ClsIncrementNo
