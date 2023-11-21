import React, { useRef } from 'react'

const data = [
    {
        title: "Title 1",
        subtitle: "Subtitle 1"
    },
    {
        title: "Title 2",
        subtitle: "Subtitle 2"
    },
    {
        title: "Title 3",
        subtitle: "Subtitle 3"
    }
]

function UseReference1() {

    const h1Ref = useRef();
    const divRef = useRef([]);
    divRef.current = [data];

    console.log(h1Ref);
    console.log(divRef);

    h1Ref.current.style.color = "Red";
    divRef.current.style.color = "Red";

return (
    <div>
        <h1></>
    </div>
)
}

export default UseReference1
