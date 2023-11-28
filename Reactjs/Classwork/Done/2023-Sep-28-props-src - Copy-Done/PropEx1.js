import React from 'react'
function Parent(abc) {
  return (
    <div>
      <h1>Parent</h1>
      <p>{abc.property}</p>
      {/* <Child username="Neeraj"/> */}
    </div>
  )
}
function Child(xyz)
{
    return(<>
    <h1>Child</h1>
    {/* <h2>{xyz.username}</h2> */}
   <Parent property="ParentProp"/>
    </>)
}
export default Child
