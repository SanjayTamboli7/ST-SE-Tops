import React, { useRef } from 'react'

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

function UseRef() {

    const h1Ref = useRef();
    const divRef = useRef();

    

   const getTag = ()=>{
    console.log(h1Ref)
    console.log(h1Ref.current)

    console.log(divRef)
    console.log(divRef.current)


    h1Ref.current.style.color ="blue"
    h1Ref.current.style.height ="100px"
    h1Ref.current.style.width ="100px"
    h1Ref.current.style.fontSize ="50px"
    h1Ref.current.style.backgroundColor ="coral"
    
    divRef.current.style.color ="pink"
   }

  return (
    <div>
        <h1 ref={h1Ref} onClick={getTag}>Heading 1</h1> 

        <div className='card'>

           

            {data.map((v)=>{
                return(
                <div ref={divRef}>
                    <h2>{v.title}</h2>
                    <p>{v.subtitle}</p>
                </div>
                )
            })}

            {/* <div>
                <h2>Title 2</h2>
                <p>Subtitle 3</p>
            </div>

            <div>
                <h2>Title 3</h2>
                <p>Subtitle 3</p>
            </div> */}


        </div>     
    </div>
  )
}

export default UseRef

