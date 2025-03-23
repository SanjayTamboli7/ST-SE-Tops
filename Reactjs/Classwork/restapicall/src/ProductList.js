import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function ProductList() {

    const [prodData, setProdData] = useState("");
    const navigate = useNavigate();

    useEffect(() => {
        fetch("http://localhost:8080/products", { method: "GET" })
            .then((res) => { return res.json() })
            .then((data) => { setProdData(data) })
            .catch((e) => { console.log(e.message) })
    }, [])

    // console.log(prodData);

    const LoadView = (id) => {
        navigate("/prod/view/" + id)
    }

    const LoadEdit = (id) => {
        console.log("in list product id = "+id)
        navigate("/prod/edit/" + id)
    }

    const LoadDelete = (id) => {
        if (window.confirm("Are you sure??")) {
            fetch("http://localhost:8080/products/" + id, {
                method: "DELETE",
                headers: { "content-type": "application/json" },
                body: JSON.stringify(prodData)
            })
                .then((res) => {
                    if (res) {
                        alert("Deleted successfully..!");
                        navigate('/')
                    }
                })

            window.location.reload();
        }
    }

    return (
        <div className='container'>
            <h4>Product List</h4>
            <div>
                <Link to='/emp/add' className='btn btn-warning m-4'>Add New (+)</Link>
            </div>
            <div className='py-4'>
                <table className=" table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {prodData && prodData.map((items) => (
                            <tr>
                                <td>{items.id}</td>
                                <td>{items.name}</td>
                                <td>{items.price}</td>
                                <td>
                                    <button onClick={() => { LoadEdit(items.id) }} className='btn btn-success me-2'>Edit</button>
                                    <button onClick={() => { LoadDelete(items.id) }} className='btn btn-danger me-2'>Delete</button>
                                    <button onClick={() => { LoadView(items.id) }} className='btn btn-info me-2'>View</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
