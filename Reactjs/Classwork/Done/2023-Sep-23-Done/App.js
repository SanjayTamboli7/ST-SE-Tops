import React from "react";
import Test from "./krishna";
import Test123 from "./himanshu";
import TestProps from "./props";
import "./App.css";


function FunctionalCompo()
{
  const xyz =
  {
    color:"#fff",
    background:"cornflowerblue"
  }

  return(
    <>
   <h1 style={xyz}> THIS IS FUCNTIONAL COMPONENT</h1>
    </>
  )

}


class ClassCompo extends React.Component
{
  render(){
    return(
      <>

      <h2 className="abc">TEST CSS</h2>
     <h1 style={{color:"red",background:"lightblue"}}> THIS IS CLASS COMPONENT</h1>
      <FunctionalCompo/>
      <Test/>
      <Test123/>
      <TestProps name="Bhavesh" age="23" course="React"/>

      </>
    )
  }
}

export default ClassCompo;
// export default FunctionalCompo;