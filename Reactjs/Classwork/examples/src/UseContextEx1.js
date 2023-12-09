import logo from './logo.svg';
import './App.css';
import { createContext, useContext, useState } from 'react';

const ThemeContext = createContext();
const CurrentUserContext = createContext();

function UseContextEx1() {

  const [theme,setTheme] = useState("light");
  const [currentUser,setCurrentUser] = useState("");
  

 
  return (
    <div className="App">

      <ThemeContext.Provider value={theme}>
        <CurrentUserContext.Provider value={{
          currentUser,setCurrentUser
        }}>

               
        <Welcome>
    {
          (true) ? <Panel title="Welcome">
          <LoginForm/>
        </Panel> : <Greeting/>
          
      }
        </Welcome>

          <input type='checkbox' value={theme=="dark"} onChange={(e)=>setTheme((e.target.checked)?"dark":"light")}></input>{theme}

        </CurrentUserContext.Provider>

      </ThemeContext.Provider>
    

      
   
    </div>
  );
}

function Welcome({children})
{
  return(
    <>
      {children}
    </>
  )
}


function Greeting()
{
  const {currentUser} = useContext(CurrentUserContext)
  return(
    <h1>Hello {currentUser}</h1>
  )
}



function Panel({children,title})
{
  const theme = useContext(ThemeContext);

  const className = "panel-"+theme;// "panel-"+"light"
return( 
  <section className={className}>
    <h1>{title}</h1>
    {children}
  </section>   
)
}


function LoginForm()
{

  const {setCurrentUser} = useContext(CurrentUserContext)
  const [fname,setFname]= useState("");
  const [lname,setLname]= useState("");

  const canlogin = fname!= "" && lname!=""
  return(
    <>

      <div>
        <label>Fname :</label>
        <input value={fname} onChange={(e)=>{setFname(e.target.value)}}></input>
      </div>

      <div>
        <label>Lname :</label>
        <input value={lname} onChange={(e)=>{setLname(e.target.value)}}></input>
      </div>

     <Button disabled={!canlogin} onClick={
      setCurrentUser({
        name:fname
      })
     } >
      Login
      </Button>
    </>
  )

}

function Button({children,onclick,disabled})
{
  const theme = useContext(ThemeContext);
  const className = "panel-"+theme;
  return(
    <>
      <button className={className} disabled={disabled} onClick={onclick}>
        {children}
      </button>
    </>
  )
}


export default UseContextEx1

