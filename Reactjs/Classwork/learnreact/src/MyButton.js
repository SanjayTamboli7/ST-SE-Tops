import React from 'react'

function handleClick() {
  alert('You clicked me!');
}

function MyButton() {
  return (
    <div>
        <h4>This is h4 tag</h4>
        {/* Respnse to event example */}
        <button onClick={handleClick}>I'm a button</button>      
    </div>
  )
}

export default MyButton
