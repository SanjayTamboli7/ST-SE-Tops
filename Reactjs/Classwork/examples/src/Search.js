import React, { useState } from 'react';

var Search = () => 
{
  const [input, setinput] = useState('');

  var items = 
  ['Leanne Graham', 
  'Ervin Howell', 
  'Clementine Bauch', 
  'Patricia Lebsack', 
  'Chelsey Dietrich' ,
  'Mrs. Dennis Schulist' ,
  'Kurtis Weissnat' ,
  'Nicholas Runolfsdottir V' ,
  'Glenna Reichert' ,
  'Clementina DuBuque'];

  return (
    <div>
      <h1>Search List</h1>

      <input
        type="text"
        placeholder="Search........."
        value={input}
        onChange={(e) => setinput(e.target.value)}
      />

{/* Without Braket */}

<ul>
        {items.filter((item) =>
      item.toLowerCase().includes(input.toLowerCase())
      ).map((val, index) => (
          <li key={index}>{val}</li>
        ))}
</ul>

{/* With Braket */}

        {/* <ul>
       {items.filter((item)=> (item.toLowerCase().includes(input.toLowerCase()))).map((val,index)=>(
        <li key={index}>{val}</li>
       ))}
      </ul> */}


        {/* {content} */}

    </div>
  );
};

export default Search;
