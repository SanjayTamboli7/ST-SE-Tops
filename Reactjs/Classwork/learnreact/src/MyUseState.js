import React, { useState } from 'react'

function MyUseState() {
    const [count, setCount] = useState(0);

    function handleClick() {
      setCount(count + 1);
    }
    
    return (
      <button onClick={handleClick}>Clicked {count}</button>
    );
}

export default MyUseState
