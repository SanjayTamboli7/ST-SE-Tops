import React, { useContext } from 'react';
import { property } from './UseContextEx';

function Child3Context() {
  const Prop1 = useContext(property)
  return (
    <div>
      <h1>CHILD 3 has now {Prop1}</h1>
    </div>
  ) 
}

export default Child3Context
