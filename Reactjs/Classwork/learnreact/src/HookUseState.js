import React from 'react'
import { useState } from 'react';
import { sculptureList } from './HookUseStateData.js';

function HookUseState() {
    const [index, setIndex] = useState(0);
    const [showMore, setShowMore] = useState(false);

    function handleClick() {
      if ((index+1) < sculptureList.length) {
        setIndex(index + 1);
      }
    }
  
    function handleMoreClick() {
      setShowMore(!showMore);
    }

    let sculpture = sculptureList[index];
    return (
      <>
        <button onClick={handleClick}>Next</button>
        <button onClick={handleMoreClick}>{showMore ? 'Hide' : 'Show'} details</button>
        <h3>  
        <i>{sculpture.name} </i> 
          by {sculpture.artist}
          ({index + 1} of {sculptureList.length})
        </h3>
        <img className='clsimg'
          src={sculpture.url} 
          alt={sculpture.alt}
        />
        {showMore && <p>{sculpture.description}</p>}
      </>
    );
  }

export default HookUseState
