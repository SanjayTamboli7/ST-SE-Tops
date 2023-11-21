import React from 'react'

function ListView() {

    const ArrList = [
        {id:1, Name:"Use Array.map"},
        {id:2, Name:"Not For Loop"},
        {id:3, Name:"Give Each Item A Unique Key"},
        {id:4, Name:"Avoid Using Array Index As The Key"}]
    
    return (
        
        // <div style={{color: "#afcc62"}} > , listStyleType: "none"
        <div style={{color: "yellow", backgroundColor: "green"}}>
        <h4>The "React Way" To Render A list</h4>
        {
            ArrList.map((data)=>{
                return(
                        <ul className="circle-checkmark">
                            <li key={data.id}>
                                {data.Name}
                            </li>
                        </ul>
                )
            })
        }
        </div>
    )
}

export default ListView
