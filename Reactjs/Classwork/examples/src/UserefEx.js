import React, { useRef } from 'react';


const data = [
    {
        title:"Title 1",
        subtitle:"Subtitle 1"
    },
    {
        title:"Title 2",
        subtitle:"Subtitle 2"
    },
    {
        title:"Title 3",
        subtitle:"Subtitle 3"
    }
]


function UserefEx() {
    const pRef = useRef();
    // const divref = useRef();
    const divRef = useRef([])
    divRef.current =[];

    const addRef = (ele)=>{

        console.log(ele)

    }


    console.log(pRef);

    const ApplyColor = ()=>{
        
        pRef.current.style.color ="blue";
        // divref.current.style.color ="red"
    }
  return (
    <div>
        <h1>Useref Example</h1>

        <div ref={pRef}>
            <h1>Hello</h1>
            <p  onClick={ApplyColor}>Bye bye</p>
        </div>
        {/* <div ref={divref}> */}
        
        {
            data.map((item)=>{

                 return(
                    <div ref={addRef}>
                        <h1>{item.title}</h1>
                        <p>{item.subtitle}</p>
                    </div>
    
                 )
            })
        }

{/* </div> */}

        {/* <div>
            <h1>Title 2</h1>
            <p>Subtitle 2</p>
        </div>

        <div>
            <h1>Title 3</h1>
            <p>Subtitle 3</p>
        </div> */}
    </div>
  )
}

export default UserefEx
  