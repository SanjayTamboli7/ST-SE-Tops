import React from 'react'

class Componentlifecycle extends React.Component {

  constructor()
  {
    super();
    this.state = {count:1}
  }

  componentDidMount()
  {
    console.log("Mounted...!")
  }

  inc = ()=>{
    this.setState({count:this.state.count+1})
  }
 
  render()
  {
    return (
      <div>
        {this.state.count}
        <button onClick={this.inc}>Increment</button>       
      </div>
    )
  }
 
  shouldComponentUpdate()
  {
    console.log("Update??...")
    return true;
  }

  componentDidUpdate()
  {
    console.log("updated...1")
  }
}

export default Componentlifecycle
