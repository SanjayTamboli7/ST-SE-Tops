import React from 'react'

function Displaytodolist() {

    // let idCtr = 0 ;
    let DivResult = `
        <h1>Todo List</h1>
        <table className="ClsTable">
        <tr>
            <td className="ClsCell">ID</td>
            <td className="ClsCell">Title</td>
            <td className="ClsCell">Edit</td>
            <td className="ClsCell">Delete</td>
        </tr>
        </table>`
    const [task, Settask] = [{id:1, title:"Task 1"}, {id:2, title:"Task 2"}, {id:3, title:"Task 3"}]
    
    let DisplayDefaultTable = ()=> {
        task.map((obj, ctr) => (
            DivResult = DivResult + 
            `<tr key={ctr}>
                <td className="ClsCell">obj.ID</td>
                <td className="ClsCell">obj.title</td>
            </tr>`
        ))
        DivResult = DivResult + '</table>'
    }

    const Addtask =(e)=>{
            Settask(e.target.value)
        }
    
    return (
    <div>
        {/* {DisplayDefaultTable} */}
        <input type='text' value="" onChange={Addtask}/>
        {DivResult}
    </div>  
  )
}

export default Displaytodolist
