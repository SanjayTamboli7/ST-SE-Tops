// import React from 'react'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

function ProductList() {
  const [productData,setProductData] =  useState("");
  const navigate = useNavigate();

  useEffect(()=>{
      fetch("http://localhost:8000/product")
      .then((res)=>{ return res.json()})
      .then((data)=>{setProductData(data)})
      .catch((e)=>{console.log(e.message)})
  })

  const LoadView =(id)=>{
      navigate("/product/view/"+id)
  }

  const LoadEdit = (id)=>{
      navigate("/product/edit/"+id)
  }

  const LoadDelete =(id)=>{
     if(window.confirm("Are you sure??"))
     {
      fetch("http://localhost:8000/product/"+id,{
          method: "DELETE",
          headers:{"content-type":"application/json"},
          body:JSON.stringify(productData)
      })
      .then((res)=>{
          if(res)
          {
              alert("Deleted successfully..!");
              navigate('/')
          }})
     
      window.location.reload();
     }
  }

// Search code starts from here 
const [searchItem, setSearchItem] = useState('')
const [filteredUsers, setFilteredUsers] = useState(productData)

const handleInputChange = (e) => { 
  const searchTerm = e.target.value;
  setSearchItem(searchTerm)

  const filteredItems = productData.filter((user) =>
  user.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  setFilteredUsers(filteredItems);
  window.alert(filteredItems);
}
// https://dev.to/alais29dev/building-a-real-time-search-filter-in-react-a-step-by-step-guide-3lmm
// Search code ends here 

return (
  <div className='App container'>        
      <h4>Product List</h4>
      <div>
          <input id='SearchText' 
            value={searchItem}
            onChange={handleInputChange}
            placeholder='Search String' style={{width: "500px"}}></input>
          <Link to='/product/add' className='btn btn-warning m-4'>Add New (+)</Link>
      </div>
      <table className='table'>
          <thead className='table-dark'>
              <tr>
                  <td>Id</td>
                  <td>Name</td>
                  <td>Price (Rs.)</td>
                  <td>Category</td>
                  <td>Action</td>
              </tr>
          </thead>
          <tbody>
          {productData && productData.map((items)=>(
              <tr>
                  <td>{items.id}</td>
                  <td>{items.name}</td>
                  <td>{items.price}</td>
                  <td>{items.category}</td>
                  <td>
                      <button onClick={()=>{LoadEdit(items.id)}} className='btn btn-success me-2'>Edit</button>
                      <button onClick={()=>{LoadDelete(items.id)}} className='btn btn-danger me-2'>Delete</button>
                      <button onClick={()=>{LoadView(items.id)}} className='btn btn-info me-2'>View</button>
                  </td>
              </tr>
          ))}          
          </tbody>
      </table>    
  </div>
)
}

export default ProductList

