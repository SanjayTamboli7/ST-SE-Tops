import React from 'react'
import { useState } from 'react';

function PropUseState() {
    const [count, setCount] = useState(0);
  
    function handleClick() {
      setCount(count + 1);
    }
  
    return (
      <div>
        <p>Counters update</p>
        <p>together</p>
        <MyButton count={count} onClick={handleClick} />
        <br></br>
        <MyButton count={count} onClick={handleClick} />
      </div>
    );
  }
  
  function MyButton({ count, onClick }) {
    return (
      <button onClick={onClick}>
        Clicked {count}
      </button>
    );
  }
  

export default PropUseState
