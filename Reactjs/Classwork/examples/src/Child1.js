import React from 'react'
import { Property } from './UseContextHook'
import { useContext } from 'react'

function Child1() {

 const p =  useContext(Property)
  return (
    <div>
        <h3>Child 1 had now {p[0].prop}</h3>
      
    </div>
  )
}

export default Child1
