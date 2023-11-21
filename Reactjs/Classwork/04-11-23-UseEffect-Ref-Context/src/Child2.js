import React, { useContext } from 'react'
import { Property } from './UseContextHook'

function Child2() {

  let prop = useContext(Property)

  return (
    <div>
        <h3>Child 2 has now this {prop[0].money} </h3>
    </div>
  )
}

export default Child2
    