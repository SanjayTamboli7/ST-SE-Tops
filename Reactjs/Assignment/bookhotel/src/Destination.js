import React from 'react'
import { Link } from 'react-router-dom'
import img from './images/100235855.jpeg'

function Destination() {
    return (
        <div className='hotels-main'>
             <div className="hotels-sec-1">
          <div> <Link to={'ShowHotels'}> <img src={img} alt="" /></Link></div>
          <div><Link to={'ShowHotels'}> <img src={img} alt="" /></Link></div>
        </div>
        <div className="hotels-sec-2">
          <div><Link to={'ShowHotels'}> <img src={img} alt="" /></Link></div>
          <div><Link to={'ShowHotels'}> <img src={img} alt="" /></Link></div>
          <div className='hotel-sec-img3'><Link to={'ShowHotels'}> <img src={img} alt="" /></Link></div>
        </div>
        </div>
    )
}

export default Destination
