import React from 'react'
import { useState } from 'react';

function StateAsSnapshot() {

    const [to, setTo] = useState('Alice');
    const [message, setMessage] = useState('Hello');
  
    function handleSubmit(e) {
      e.preventDefault();
      setTimeout(() => {
        alert(`You said ${message} to ${to}`);
      }, 5000);
    }

  return (
    <form onSubmit={handleSubmit}>
      <label>
        To:{' '}
        <select
          value={to}
          onChange={e => setTo(e.target.value)}>
          <option value="Alice">Alice</option>
          <option value="Bob">Bob</option>
        </select>
      </label>
      <textarea
        placeholder="Message"
        value={message}
        onChange={e => setMessage(e.target.value)}
      />
      <br></br>
      <p>Wait for 5 seconds for response</p>
      <br></br>
      <button type="submit">Send</button>
    </form>
  )
}

export default StateAsSnapshot
