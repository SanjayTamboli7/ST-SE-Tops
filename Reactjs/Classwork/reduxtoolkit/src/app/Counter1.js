import React, { useReducer } from 'react';

// 1. Define the reducer function
// This function takes the current state and an action, and returns the new state.
const counterReducer = (state, action) => {
  switch (action.type) {
    case 'INCREMENT':
      return { count: state.count + 1, count1: state.count1 - 1 };
    case 'DECREMENT':
      return { count: state.count - 1, count1: state.count1 + 1 };
    case 'RESET':
      return { count: 0, count1: 0 };
    default:
      // It's good practice to throw an error for unhandled actions
      throw new Error();
  }
};

// 2. Define the initial state
const initialState = { count: 0, count1: 0 };

function Counter1() {
  // 3. Use the useReducer hook
  // It returns the current state and a dispatch function.
  const [state, dispatch] = useReducer(counterReducer, initialState);

  return (
    <div>
      <p>Count: {state.count}</p>
      <p>Count1: {state.count1}</p>
      <button onClick={() => dispatch({ type: 'INCREMENT' })}>Increment</button>
      <button onClick={() => dispatch({ type: 'DECREMENT' })}>Decrement</button>
      <button onClick={() => dispatch({ type: 'RESET' })}>Reset</button>
    </div>
  );
}

export default Counter1;