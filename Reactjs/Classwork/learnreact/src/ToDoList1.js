import React from 'react'

function ToDoList1() {

    const person = {
        name: 'Gregorio Y. Zara',
        theme: {
          backgroundColor: 'black',
          color: 'yellow'
        }
      };
    const avtar = "https://i.imgur.com/7vQD0fPs.jpg";
    const description = "Gregorio Y. Zara";
  return (
    <div style={person.theme}>
      <h1>{person.name}'s Todos</h1>
      <img
        className="avatar"
        // src="https://i.imgur.com/7vQD0fPs.jpg"
        // alt="Gregorio Y. Zara"
        src={avtar}
        alt={description}
      />
      <ul>
        <li>Improve the videophone</li>
        <li>Prepare aeronautics lectures</li>
        <li>Work on the alcohol-fuelled engine</li>
      </ul>
    </div>
  )
}

export default ToDoList1
