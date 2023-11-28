import React from 'react'
import ChildcContext from './ChildcContext'
import ChildbContext from './ChildbContext'
import ChildaContext from './ChildaContext'

function ParentContext() {
  return (
    <div>
      <h1>Parent CONTEXT</h1>      
      <ChildaContext/>
      <ChildcContext/>
      <ChildbContext/>           
    </div>
  )
}

export default ParentContext
