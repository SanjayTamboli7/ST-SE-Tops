import React, { createContext } from 'react'
import ParentContext from './ParentContext'

export const property = createContext();

function UseContextEx() {
  return (
    <div>
        <h1>Usecontext Example</h1>
       <property.Provider value={1234}>
       <ParentContext/>
       </property.Provider>
      
    </div>
  )
}

export default UseContextEx
