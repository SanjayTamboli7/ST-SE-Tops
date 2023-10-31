import React from 'react'

class ClsChangeObject extends React.Component {
    constructor()
    {
        super();
        this.state ={c:[{"Val1": "Sanjay"}]}     
    }

    ChangeObject = ()=> {  
        this.setState({c:[{"Val1": "Himanshu"}]})
    }

    render()
    {
        return (
            <div>
                {this.state.c[0].Val1}
                <button onClick={this.ChangeObject}>Class Change Object</button>
            </div>
        )
    }
}

export default ClsChangeObject 
