import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  const [data,setData] = useState(
    {
      "name":"Dheeraj",
      "age":23,
      "course":"React"
    }
    )

  const handleChange = ()=>{
    // setData(12)
    // setData(data+1)

    // setData(data => data+1)
    // setData("kdfjh")
    setData({"name":"hello","age":56})
  }
  return (
    <div className="App">
     {/* <h1>Hello {data.name + " " + data.age}</h1> */}
    <input
     type="textbox"
     value={data.name}
     onChange={(e)=>
      setData(
          {
            ...data,
            "name":e.target.value,
           }
        )     
      }}
     />
     <b>Hello {data.name}</b>
     <h3>Course:{data.course}</h3>
     <button onClick={handleChange}>Click Me</button>
    </div>
  );
}

export default App;
