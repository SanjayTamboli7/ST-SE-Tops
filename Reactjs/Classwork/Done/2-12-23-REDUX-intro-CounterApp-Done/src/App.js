import logo from './logo.svg';
import './App.css';

import { useDispatch, useSelector } from 'react-redux';
import { decrement, increment } from './action';



function App() {

  // npm i redux
  // npm i react-redux 
  // npm i @reduxjs/toolkit 

  const Dispatch = useDispatch()
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
