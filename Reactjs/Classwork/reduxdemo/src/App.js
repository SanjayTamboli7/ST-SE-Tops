// import logo from './logo.svg';
import './App.css';

import { useDispatch, useSelector } from 'react-redux';
import { decrement, increment } from './action';

function App() {

  // npm i redux
  // npm i react-redux 
  // npm i @reduxjs/toolkit 

  // https://dev.to/oahehc/redux-data-flow-and-react-component-life-cycle-11n

  // The useDispatch hook is used to update the state of the component and return a new state. Redux boilerplate code made the 
  // library a little tedious but with the introduction of these hooks in redux, the code became even more straightforward and 
  // cleaner.

  const Dispatch = useDispatch()

  // The useSelector hook is used to extract the state of a component from the redux store using the selector function. 

  const counter = useSelector(state => state.count)

  return (

    <div className="App">      
     <button onClick={()=>{Dispatch(increment())}}>Increment</button>
     {counter}
     <button  onClick={()=>{Dispatch(decrement())}}>Decrement</button>
    </div>
  );
}

export default App;
