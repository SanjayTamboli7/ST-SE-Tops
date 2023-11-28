import React, { useState } from "react";

function UsestateEX() {
  const [str, setStr] = useState("hello");
  const [num, setNum] = useState(0);
  const [c, setC] = useState({ count: 0 });
  const [arr, setArr] = useState([
    {name:"Urvi"},
    {email:"u@gmail.com"},
    {phone:12321}
]);

const [boolean,setBoolean] = useState(false);


const [nestedObj,setNestedObj] = useState({
    name:"Bhavesh",
    address:{
        city:"Ahmedabad",
        area:"CG"
    }
})



  return (
    <div>

        <input type="checkbox"   onChange={(e)=>{setBoolean(e.target.checked)}}></input>
        <b>{(boolean)? "t":"Khabar Padi?"}</b>

    <h1 onClick={()=>{
        setNestedObj({
            ...nestedObj,
            address:{
                ...nestedObj.address,
                area:"SG"
            }

        })
    }}>Nested Object Example</h1>
    <h3>Name : {nestedObj.name}</h3>
    <h3>City : {nestedObj.address.city}</h3>
    <h3>Area : {nestedObj.address.area}</h3>

      String : '
      <input
        type="text"
        value={str}
        onChange={(e) => {
          setStr(e.target.value);
        }}
      ></input>
      <br />
      <h2>input value: {str} </h2>
      <h3
        onClick={() => {
          // setNum(num-1)
          setNum(num + 12);
        }}
      >
        number : {num}{" "}
      </h3>
      <br />
      {/* <h3 onClick={()=>{
                setC({count:c.count + 1})
            }}>object : {c.count}</h3><br/>  */}
      <h3
        onClick={() => {
          setC({ count: c.count + 1 });
        }}
      >
        object : {c.count}
      </h3>
      <br />


      <h3 onClick={() => {
        setArr([
           ...arr,
            {phone:"hi"},
            {email:"hi@gmail.com"}
        ])
      }}>
        array : {arr.map((v)=>{
            return(
              <>
                  <p>{v.name}</p>
                <p>{v.email}</p>
                <p>{v.phone}</p>
              </>
            )
        })}
        </h3>
      <br />
    </div>
  );
}

export default UsestateEX;
