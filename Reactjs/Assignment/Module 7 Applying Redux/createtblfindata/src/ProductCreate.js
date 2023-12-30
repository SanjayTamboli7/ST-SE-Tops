import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

function ProductCreate() {
  const [id,setId] = useState("");
  const [name,setName] = useState("");
  const [price,setPrice] = useState("");
  const [category,setCategory] = useState("");

  const navigate = useNavigate();

  const handleClick =(e)=>{

      // We call a preventDefault on the event when submitting the form, and this will cancel the default event behavior 
      // (browser refresh) while allowing us to execute any code we write inside handleSubmit.        
      
      e.preventDefault();
      console.log(id,name,price,category)

      const empData = {id,name,price,category};

      fetch("http://localhost:8000/product",{
          method: "POST",
          headers:{"content-type":"application/json"},
          body:JSON.stringify(empData)
      })
      .then((res)=>{
          if(res)
          {
              alert("Saved successfully..!");
              navigate('/');
          }})
  }

return (
  <div className='App'>
      <h4>Add Product</h4>
      <div className='row justify-content-center text-start'>

          <form className='col-6' onSubmit={handleClick}>
              <div className='col-12'>
                  <label className='form-label'>Id</label>
                  <input type='text' disabled="disabled" className='form-control'></input>
              </div>
              <div className='col-12'>
                  <label className='form-label'>Name</label>
                  <input value={name} onChange={(e)=>{setName(e.target.value)}} type='text' className='form-control'></input>
              </div>
              <div className='col-12'>
                  <label className='form-label'>price</label>
                  <input value={price} onChange={(e)=>{setPrice(e.target.value)}} type='text' className='form-control'></input>
              </div>
              <div className='col-12'>
                  <label className='form-label'>category</label>
                  <input value={category} onChange={(e)=>{setCategory(e.target.value)}} type='text' className='form-control'></input>
              </div>
              <div className='col-12 mt-3' >
                <button type='submit' className='btn btn-primary me-2'>Save</button>
                <Link to="/" className='btn btn-info '>Back</Link>
              </div>
          </form>
      </div>     
  </div>
)
}

export default ProductCreate
