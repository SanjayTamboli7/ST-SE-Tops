import React, { useState } from 'react'
import AddToDo from './AddToDo';
import TaskList from './TaskList';
// import Displaytodolist from './Displaytodolist';

function App() {

    const intialTodos = [
        {id:1,title:"Apple"},
        {id:2,title:"Banana"},
        {id:3,title:"Mango"},
        {id:4,title:"Kiwi"}
    ];
    let nextId = intialTodos.length;
    const [todos,setTodos] = useState(intialTodos);
    const handleAddTodo = (title)=>{
        setTodos([
            ...todos,
            {
                id:todos.length + 1,
                title:title
            }
        ])
        nextId = nextId + 1;
    }
    // console.log(todos);
    const handleChangeTodo = (nextTodo)=>{
        setTodos(
            todos.map((t)=>{
                if(t.id === nextTodo.id)
                {
                    return nextTodo;
                }
                else 
                {
                    return t;
                }        
               })
        )      
    }

    const handleDeleteTodo = (todoId)=>{
        setTodos(
            todos.filter((t)=>{
                return t.id !== todoId
            })
        )
    }

  return (
    <div>
        <AddToDo onaddTodo={handleAddTodo}/>
        <TaskList
        todos={todos}
        onChangeTodo={handleChangeTodo}
        onDeleteTodo={handleDeleteTodo}
        />      
        {/* <Displaytodolist/> */}
    </div>
  )
}

export default App
