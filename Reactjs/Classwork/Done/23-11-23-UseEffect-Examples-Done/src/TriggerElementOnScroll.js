import React, { useEffect, useRef } from 'react'

function TriggerElementOnScroll() {

    const items =[];
    for(let i=0;i<50;i++)
    {
       items.push( <li>item {i+1} ..! Keep Scrolling..!</li>)
    }

  return (
    <div>
        <ul>
            {items}
        </ul>             
    </div>
  )
}

export default TriggerElementOnScroll

export function Box()
{

    const divRef = useRef();   
    useEffect(()=>{
        const div = divRef.current;
        console.log(div)
        const observer = new IntersectionObserver((entries)=>{
            const entry = entries[0];
            if(entry.isIntersecting)
            {
                document.body.style.background ="#000";
                document.body.style.color ="#fff"
            }
            else 
            {
                document.body.style.background ="#fff";
                document.body.style.color ="#000"
            }            
        },{
            // threshold:1
            threshold:.5
        });// class ends (Constructor function)
        observer.observe(div);
    },[])

    return(
        <div ref={divRef} style={{
            height:100,
            width:100,
            background:"blue",
            color:"#fff",
            margin:20,
            border:"3px solid #000"
        }}>        
        </div>
    )
}
