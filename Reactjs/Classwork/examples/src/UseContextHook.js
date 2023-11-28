import React, { createContext } from 'react'
import ParentCompo from './ParentCompo.js';

export const Property = createContext();

function UseContextHook() {
  return (
    <div>

       <Property.Provider value={[{prop:"realEstate",money:2000}]}>
         <ParentCompo/>
       </Property.Provider>
      
    </div>
  )
}

export default UseContextHook


