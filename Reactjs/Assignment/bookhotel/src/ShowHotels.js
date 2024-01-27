import React, { useContext } from 'react'
import {hoteldata} from './Hoteljsonfile'
import { Link } from 'react-router-dom'
import { Hoteldata } from './App'
import './Hotel.css'
import { BsChevronRight } from "react-icons/bs";
import { FaStar } from "react-icons/fa";
import { CgArrowTopRight } from "react-icons/cg"
import { BsFillHandThumbsUpFill } from "react-icons/bs";

function ShowHotels() {

 const {showhoteldatas} = useContext(Hoteldata)

  return (

    <div>

{hoteldata.map((v)=>(

<div className="hotel-info">

<div className="hotel-info-img">
  <Link to={'/ShowHotelImages'}>
  <img src={v.imgsrc} alt="" onClick={()=>{showhoteldatas(v)}}/>
  </Link>
</div>

<div className="hotel-details">
  <div className="hotel-details-part1">
    <h4 className='hotel-name'>{v.name}</h4>
    <div className='hotel-review-stars'> <FaStar /><FaStar /><FaStar /><FaStar /><FaStar />  <BsFillHandThumbsUpFill /> <span>Genius</span> </div>
    <p> <u>{v.address}</u> <u>Show on map</u> </p>
    <p className='hotel-details-color'> <CgArrowTopRight /><CgArrowTopRight /><CgArrowTopRight /> Travel Sustainable Lavel 2</p>

    <div className="hotel-details-border">
      <b>{v.mainDescription}</b>
      <p>{v.subDescription}</p>
      <b className='hotel-details-color'> <CgArrowTopRight /> Free cancellation</b> <br />
      <b className='hotel-details-color'> <CgArrowTopRight />  No Prepayment needed - pay at the property</b>
    </div>
  </div>

  <div className="hotel-details-part2">
    <h2>Very Good</h2>
    <p>{v.totalReviews} reviews</p>
    <p className="hotel-adulte">{v.stayPersonDetail}</p>
    <h2>{v.cost}</h2>
    <p>+{v.taxFee} taxes and fees</p>
    <button>See availability <BsChevronRight /></button>
  </div>
</div>

</div>

))}
    </div>

    
  )
}

export default ShowHotels
