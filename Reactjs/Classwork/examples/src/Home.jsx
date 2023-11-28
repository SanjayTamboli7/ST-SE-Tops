import React from 'react'
import "./mystyle.css"

function Home() {
  return (
    <>    
    <div className="header">header</div>
    <div className="container-fluid">
    <div className="content bg-info row">
        <div className="col-xl-6 col-3 border border-dark">Col 1</div>
        <div className="col-xl-6 col-3 border border-dark">Col 2</div>
        <div className="col-xl-6 col-3 border border-dark">Col 3</div>
        <div className="col-xl-6 col-3 border border-dark">Col 4</div>
    </div>
    </div>
    <div className="footer">Footer</div>    
    </>
  )
}

export default Home
