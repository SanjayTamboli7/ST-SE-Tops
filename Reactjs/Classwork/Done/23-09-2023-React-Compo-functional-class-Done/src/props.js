
import img1 from './img1.jpg';
import testImg from "./images/testImg.webp";

function T()
{
   return(
        <>{alert("hello basic alert...!")}</>
    )
}

function TestProps(props)
{

    // handleClick()
    // {
    //     alert("Hello Alert..!")
    // }

    const testX = ()=>{alert("=xjkhgjvgxcgxc")}

    return(
        <>
        <T/>
           <h3 style={{color:"blue",fontSize:"90px"}}>TEST PROP</h3>

           <button onClick={testX}>Click</button>


           <h1  className="abc"> {props.name}</h1>
            <h1  className="abc">{props.age}</h1>
            <h1  className="abc">{props.course}</h1>
            {/* <img src="https://www.sixt.com/magazine/wp-content/uploads//sites/6/2022/04/Bugatti-Bolide-Hypercar-resize-1024x683.jpg"/> */}
           
           <img src={img1}/>
           <img src={testImg}/>
        
         </>
       
    )
}

export default TestProps;