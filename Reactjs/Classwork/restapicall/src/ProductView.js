import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { Link, useNavigate } from 'react-router-dom';

export default function ProductView() {

    const { Id } = useParams();
    const [prodData, setProdData] = useState("");

    console.log("In view prod id = " + Id);

    useEffect(() => {

        fetch("http://localhost:8080/products/" + Id, { method: "GET" })
            .then((res) => { return res.json() })
            .then((data) => {
                setProdData(data)
            })

    })

    return (
        <div className='App container'>
            <h4>View Details</h4>
            <table className='table' >
                <thead className='table-dark'>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Price</td>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>{Id}</td>
                        <td>{prodData.name}</td>
                        <td>{prodData.price}</td>
                    </tr>
                </tbody>
            </table>
                    <div className='col-12 mt-3' >
                        <Link to="/" className='btn btn-info '>Back</Link>
                    </div>
        </div>
    )
}
