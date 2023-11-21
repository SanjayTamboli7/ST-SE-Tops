import React from 'react'

function FetchAPIData() {
    // const b3 = document.getElementById('btn3');
    function GetAPI()
    {
    fetch('https://jsonplaceholder.typicode.com/users')
    .then((res)=>{return res.json() })        
    .then((data)=>{

     const x = data.map(function(v,i,a)
        {
            return v.name +" "+ v.username
        })

        // console.log(x)
        var data1 = `<h1>Registration</h1>
<table border="1" style="background:gray">
<tr>`
console.log(x)
let val = 0;
for(val of x)
{
data1 += `<td>${val}</td>`
}

data1 += `</tr></table>`
// document.querySelector('.d1').innerHTML = data1;
document.querySelector('btn3').innerHTML = data1;
    })
}
  return (
    <div>
      <button id="btn3" onClick={GetAPI}>Get API Data</button>
    </div>
  )
}

export default FetchAPIData
