import React from 'react'
import Child3Context from './Child3Context'
import Child2Context from './Child2Context'
import Child1Context from './Child1Context'

function ParentContext() {
  return (
    <div>
      <h1>Parent CONTEXT</h1>
      
      <Child1Context/>
      <Child3Context/>
      <Child2Context/>
     
      
    </div>
  )
}

export default ParentContext
