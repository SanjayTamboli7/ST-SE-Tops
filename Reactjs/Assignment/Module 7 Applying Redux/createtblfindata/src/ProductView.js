import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

function ProductView() {
    const {productId} = useParams();
    const [productData,setProductData] = useState("");

    useEffect(()=>{

        fetch("http://localhost:8000/product/"+productId)
        .then((res)=>{ return res.json()})
        .then((data)=>{
            setProductData(data)
        })

    })
  return (
    <div className='App container'>
        <h4>View Product</h4>
        <table className='table' >
          <thead className='table-dark'>
          <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Price (Rs.)</td>
                <td>Category</td>
            </tr>
          </thead>

           <tbody>
           <tr>
                <td>{productData.id}</td>
                <td>{productData.name}</td>
                <td>{productData.price}</td>
                <td>{productData.category}</td>
            </tr>
            </tbody>            
        </table>
    </div>
  )
}

export default ProductView
