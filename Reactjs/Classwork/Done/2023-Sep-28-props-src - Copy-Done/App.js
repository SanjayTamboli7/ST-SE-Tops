import logo from './logo.svg';
import './App.css';
import PropEx from './PropEx';
import Child from './PropEx1';
import ClassPropEx from './ClassProps';

function Test()
{
  alert("FUN.. !")
}

function App() {
  return (
    <>
    <button onClick={Test}>Alert</button>
    
      hello React...!
      {/* <PropEx name="Bhavesh" age="12" course="React"/> */}

      <PropEx/>
     <Child/>
     <ClassPropEx name="Meet"/>
    </>
  );
}

export default App;
