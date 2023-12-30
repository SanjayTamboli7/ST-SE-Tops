import React, { useState ,useEffect} from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';

function ProductEdit() {
    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [price,setPrice] = useState("");
    const [category,setCategory] = useState("");

    const navigate = useNavigate();
    const {productId} = useParams();

    useEffect(()=>{

        fetch("http://localhost:8000/product/"+productId)
        .then((res)=>{ return res.json()})
        .then((data)=>{
            setId(data.id)
            setName(data.name)
            setPrice(data.price)
            setCategory(data.category)
        })},[])

    const handleClick =(e)=>{
        e.preventDefault();
        console.log(id,name,price,category)
        const productData = {id,name,price,category};
        fetch("http://localhost:8000/product/"+productId,{
            method: "PUT",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(productData)
        })
        .then((res)=>{
            if(res)
            {
                alert("Updated successfully..!");
                navigate('/')
            }
        }
        )
    }

  return (
    <div className='App'>
        <h4>Edit Product</h4>
        <div className='row justify-content-center text-start'>
            <form className='col-6' onSubmit={handleClick}>
                <div className='col-12'>
                    <label className='form-label'>Id</label>
                    <input value={id} type='text' disabled="disabled" className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Name</label>
                    <input value={name} onChange={(e)=>{setName(e.target.value)}} type='text' className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Price</label>
                    <input value={price} onChange={(e)=>{setPrice(e.target.value)}} type='text' className='form-control'></input>
                </div>
                <div className='col-12'>
                    <label className='form-label'>Category</label>
                    <input value={category} onChange={(e)=>{setCategory(e.target.value)}} type='text' className='form-control'></input>
                </div>
                <div className='col-12 mt-3' >
                  <button type='submit' className='btn btn-primary me-2'>Save</button>
                  <Link to="/" className='btn btn-info'>Back</Link>
                </div>
            </form>
        </div>     
    </div>
  )
}

export default ProductEdit
